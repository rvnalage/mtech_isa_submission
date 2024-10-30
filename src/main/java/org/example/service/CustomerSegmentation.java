package org.example.service;

import com.opencsv.CSVReader;
import org.example.dtos.Cluster;
import org.example.dtos.Customer;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CustomerSegmentation {

    private static final int NUM_CUSTOMERS = 4;

    public List<Customer> loadCustomerData(String filename) {
        List<Customer> customers = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(filename));
            String[] nextLine;
            reader.readNext();
            // Read each line of the CSV file
            while ((nextLine = reader.readNext()) != null) {
                // Process the data as needed
                int id = Integer.parseInt(nextLine[0]);
                double milk = Double.parseDouble(nextLine[1]);
                double grocery = Double.parseDouble(nextLine[2]);
                customers.add(new Customer(id, milk, grocery));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public double[][] calculateDistanceMatrix(List<Customer> customers) {
        int size = customers.size();
        double[][] distanceMatrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                distanceMatrix[i][j] = distanceMatrix[j][i] = calculateDistance(customers.get(i), customers.get(j));
            }
        }
        return distanceMatrix;
    }

    public double calculateDistance(Customer a, Customer b) {
        double milkDiff = a.getMilk() - b.getMilk();
        double groceryDiff = a.getGrocery() - b.getGrocery();
        return Math.sqrt(milkDiff * milkDiff + groceryDiff * groceryDiff);
    }

    public List<Cluster> agglomerativeClustering(double[][] distanceMatrix, List<Customer> customers) {
        List<Cluster> clusters = new ArrayList<>();
        for (Customer customer : customers) {
            clusters.add(new Cluster(customer));
        }

        while (clusters.size() > 1) {
            // Find the two closest clusters
            double minDistance = Double.MAX_VALUE;
            int clusterAIndex = -1;
            int clusterBIndex = -1;

            for (int i = 0; i < clusters.size(); i++) {
                for (int j = i + 1; j < clusters.size(); j++) {
                    double distance = calculateClusterDistance(clusters.get(i), clusters.get(j), distanceMatrix);
                    if (distance < minDistance) {
                        minDistance = distance;
                        clusterAIndex = i;
                        clusterBIndex = j;
                    }
                }
            }

            // Merge the closest clusters
            Cluster mergedCluster = mergeClusters(clusters.get(clusterAIndex), clusters.get(clusterBIndex));
            clusters.remove(clusterBIndex);
            clusters.set(clusterAIndex, mergedCluster);
        }

        return clusters;
    }

    public double calculateClusterDistance(Cluster a, Cluster b, double[][] distanceMatrix) {
        // Using single-linkage clustering (minimum distance)
        double minDistance = Double.MAX_VALUE;
        for (Customer memberA : a.getMembers()) {
            for (Customer memberB : b.getMembers()) {
                double distance = distanceMatrix[memberA.getId() - 1][memberB.getId() - 1];
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }

    public Cluster mergeClusters(Cluster a, Cluster b) {
        a.getMembers().addAll(b.getMembers());
        return a;
    }


}






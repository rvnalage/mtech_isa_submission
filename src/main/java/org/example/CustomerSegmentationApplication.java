package org.example;

import org.example.dtos.Cluster;
import org.example.dtos.Customer;
import org.example.service.CustomerSegmentation;

import java.util.List;

public class CustomerSegmentationApplication {

    public static void main(String[] args) {
        CustomerSegmentation customerSegmentation = new CustomerSegmentation();
        List<Customer> customers = customerSegmentation.loadCustomerData("src/main/resources/inputs/WholesaleDataInput.csv");
        double[][] distanceMatrix = customerSegmentation.calculateDistanceMatrix(customers);
        List<Cluster> clusters = customerSegmentation.agglomerativeClustering(distanceMatrix, customers);
        // Output clusters
        for (Cluster cluster : clusters) {
            System.out.println("Final Cluster:");
            for (Customer customer : cluster.getMembers()) {
                System.out.println(" - " + customer);
            }
        }
    }

}
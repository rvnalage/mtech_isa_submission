package org.example.service;

import java.util.List;
import java.util.Arrays;

public class KNN {

    private final int k;

    public KNN(int k) {
        this.k = k;
    }

    public int classify(double[] testInstance, List<double[]> trainingData) {
        double[][] distances = new double[trainingData.size()][2]; // Distance and label

        for (int i = 0; i < trainingData.size(); i++) {
            distances[i][0] = calculateDistance(testInstance, trainingData.get(i));
            distances[i][1] = trainingData.get(i)[trainingData.get(i).length - 1]; // Label
        }

        Arrays.sort(distances, (a, b) -> Double.compare(a[0], b[0]));

        return vote(distances);
    }

    private double calculateDistance(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length - 1; i++) {
            sum += Math.pow(a[i] - b[i], 2);
        }
        return Math.sqrt(sum);
    }

    private int vote(double[][] distances) {
        int[] count = new int[2]; // Assuming binary classification (0 and 1)
        for (int i = 0; i < k; i++) {
            int label = (int) distances[i][1];
            count[label]++;
        }
        return (count[0] > count[1]) ? 0 : 1;
    }

}

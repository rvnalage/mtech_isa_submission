package org.example.util;

import java.util.List;

public class DataNormalizer {

    public static void normalize(List<double[]> data) {
        int numFeatures = data.get(0).length - 1; // Last column is the label
        double[] min = new double[numFeatures];
        double[] max = new double[numFeatures];
        // Initialize min and max
        for (int i = 0; i < numFeatures; i++) {
            min[i] = Double.MAX_VALUE;
            max[i] = Double.MIN_VALUE;
        }
        // Find min and max for each feature
        for (double[] row : data) {
            for (int i = 0; i < numFeatures; i++) {
                if (row[i] < min[i]) min[i] = row[i];
                if (row[i] > max[i]) max[i] = row[i];
            }
        }
        // Normalize data
        for (double[] row : data) {
            for (int i = 0; i < numFeatures; i++) {
                row[i] = (row[i] - min[i]) / (max[i] - min[i]);
            }
        }
    }
}

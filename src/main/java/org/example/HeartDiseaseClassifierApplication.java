package org.example;

import org.example.service.KNN;
import org.example.util.DataLoader;
import org.example.util.DataNormalizer;

import java.util.List;

public class HeartDiseaseClassifierApplication {

    public static void main(String[] args) {
        String filePath = "src/main/resources/inputs/ClevelandHeartDiseaseInput.csv";
        List<double[]> data = DataLoader.loadData(filePath);
        DataNormalizer.normalize(data);

        int totalData = data.size();
        int trainSize = (int) (totalData * 0.8);
        List<double[]> trainingData = data.subList(0, trainSize);
        List<double[]> testingData = data.subList(trainSize, totalData);

        for (int k = 1; k <= trainingData.size(); k++) {
            KNN knn = new KNN(k);
            int correct = 0;

            for (double[] testInstance : testingData) {
                int predicted = knn.classify(testInstance, trainingData);
                if (predicted == testInstance[testInstance.length - 1]) {
                    correct++;
                }
            }

            Double accuracy = (double) correct / k;
            System.out.println("Accuracy for k = " + k + ": " + accuracy);
        }
    }

}
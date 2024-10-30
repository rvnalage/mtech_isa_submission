package org.example.util;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<double[]> loadData(String filename) {
        //
        List<double[]> data = new ArrayList<>();
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(filename));
            String[] nextLine;
            reader.readNext();
            // Read each line of the CSV file
            while ((nextLine = reader.readNext()) != null) {
                double[] row = new double[nextLine.length];
                for (int i = 0; i < nextLine.length; i++) {
                    row[i] = Double.parseDouble(nextLine[i]);
                }
                data.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}

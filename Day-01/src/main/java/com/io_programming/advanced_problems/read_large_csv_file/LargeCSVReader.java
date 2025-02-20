package com.io_programming.advanced_problems.read_large_csv_file;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public void readCSVInChunks(String filePath) {
        int linesProcessed = 0;
        int chunkSize = 100;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                linesProcessed++;
                if (linesProcessed % chunkSize == 0) {
                    System.out.println("Processed " + linesProcessed + " records.");
                }
            }
            System.out.println("Total records processed: " + linesProcessed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/sample4";
        LargeCSVReader reader = new LargeCSVReader();
        reader.readCSVInChunks(filePath);
    }
}

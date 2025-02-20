package com.io_programming.advanced_problems.detect_duplicate_in_csv;
import java.io.*;
import java.util.*;

public class DetectDuplicateInCsvFile  {

    public void detectDuplicates(String filePath) {
        Set<String> uniqueIDs = new HashSet<>();
        List<String> duplicates = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if (!uniqueIDs.add(id)) {
                    duplicates.add(line);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                System.out.println("Duplicate records:");
                duplicates.forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/sample5";
        DetectDuplicateInCsvFile detector = new DetectDuplicateInCsvFile();
        detector.detectDuplicates(filePath);
    }
}




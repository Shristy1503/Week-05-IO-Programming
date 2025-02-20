package com.io_programming.advanced_problems.merge_csv_files;
import java.io.*;
import java.util.*;

public class MergeTwoCsvFiles {
    public static void main(String[] args) {
        // has ID, Name, Age
        String file1 = "src/student1";
        // has ID, Marks, Grade
        String file2 = "src/student2";
        String outputFile = "src/merged_students";

        List<String[]> students1 = readCsvFile(file1);
        List<String[]> students2 = readCsvFile(file2);

        Map<String, String[]> studentMap = mergeRecords(students1, students2);

        writeMergedCsvFile(outputFile, studentMap);
        System.out.println("Merged file created successfully: " + outputFile);
    }
    // Method to read CSV and return a list of records
    public static List<String[]> readCsvFile(String filename) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine(); // Read and ignore header

            String line;
            while ((line = br.readLine()) != null) {
                // Split by comma and trim spaces
                String[] record = line.split(",\\s*");
                if (record.length > 1) {
                    records.add(record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return records;
    }

    // Method to merge two CSV records based on ID
    public static Map<String, String[]> mergeRecords(List<String[]> file1, List<String[]> file2) {
        Map<String, String[]> studentMap = new LinkedHashMap<>();

        for (String[] record : file1) {
            studentMap.put(record[0], new String[]{record[0], record[1], record[2], "N/A", "N/A"});
        }

        for (String[] record : file2) {
            if (studentMap.containsKey(record[0])) {
                studentMap.get(record[0])[3] = record[1];
                studentMap.get(record[0])[4] = record[2];
            } else {
                studentMap.put(record[0], new String[]{record[0], "Unknown", "Unknown", record[1], record[2]});
            }
        }
        return studentMap;
    }

    // Method to write merged records to a new CSV file
    public static void writeMergedCsvFile(String outputFile, Map<String, String[]> studentMap) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade\n");

            for (String[] record : studentMap.values()) {
                bw.write(String.join(",", record) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + outputFile);
        }
    }
}

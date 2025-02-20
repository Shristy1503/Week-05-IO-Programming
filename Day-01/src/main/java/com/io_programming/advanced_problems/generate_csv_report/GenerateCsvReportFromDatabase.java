package com.io_programming.advanced_problems.generate_csv_report;
import java.io.*;
import java.util.*;

public class GenerateCsvReportFromDatabase {

    public void generateCSVReport(String inputFilePath, String outputFilePath) {
        List<String[]> employeeRecords = readCSV(inputFilePath);
        writeToCSV(employeeRecords, outputFilePath);
    }

    private List<String[]> readCSV(String filePath) {
        List<String[]> records = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                records.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }

    private void writeToCSV(List<String[]> records, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Writing headers
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();

            // Writing records
            for (String[] record : records) {
                writer.write(String.join(",", record));
                writer.newLine();
            }

            System.out.println("CSV Report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "src/employees";
        String outputFilePath = "src/sample4";
        GenerateCsvReportFromDatabase reportGenerator = new GenerateCsvReportFromDatabase();
        reportGenerator.generateCSVReport(inputFilePath, outputFilePath);
    }
}

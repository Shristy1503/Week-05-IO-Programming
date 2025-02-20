package com.io_programming.intermediate_problems.sort_csv_recordsby_column;
import java.io.*;
import java.util.*;

public class SortCsvBySalary {
    public static void main(String[] args) {
        String filename = "src/employees";

        List<String[]> employees = readCsvFile(filename);
        if (employees.isEmpty()) {
            System.out.println("No valid employee data found!");
            return;
        }

        sortEmployeesBySalary(employees);
        printTopEmployees(employees, 5);
    }

    // Method to read CSV file and store employee data
    public static List<String[]> readCsvFile(String filename) {
        List<String[]> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine();
            System.out.println("Header: " + header);

            String line;
            while ((line = br.readLine()) != null) {
                // Split by comma and remove spaces
                String[] record = line.split(",\\s*");
                if (record.length >= 4) {
                    employees.add(record);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (IOException e) {
            System.out.println("Error: Problem reading the file!");
        }
        return employees;
    }

    // Method to sort employees by salary in descending order
    public static void sortEmployeesBySalary(List<String[]> employees) {
        int n = employees.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double salary1 = Double.parseDouble(employees.get(i)[3].trim());
                double salary2 = Double.parseDouble(employees.get(j)[3].trim());

                if (salary1 < salary2) {
                    String[] temp = employees.get(i);
                    employees.set(i, employees.get(j));
                    employees.set(j, temp);
                }
            }
        }
    }

    // Method to print the top N highest-paid employees
    public static void printTopEmployees(List<String[]> employees, int topN) {
        System.out.println("\nTop " + topN + " Highest Paid Employees:");
        for (int i = 0; i < Math.min(topN, employees.size()); i++) {
            System.out.println("ID: " + employees.get(i)[0] +
                    ", Name: " + employees.get(i)[1] +
                    ", Department: " + employees.get(i)[2] +
                    ", Salary: " + employees.get(i)[3]);
        }
    }
}

package com.io_programming.advanced_problems.validate_csv_data;
import java.io.*;
import java.util.*;
import java.util.regex.*;
public class ValidateCsvDataBeforeProcessing {
    public static void main(String[] args) {
        String filename = "src/sample3";
        List<String[]> validEmployees = new ArrayList<>();
        //call method to validate csv data
        processCSV(filename, validEmployees);
    }
    // Method to process the CSV file and validate data
    public static void processCSV(String filename, List<String[]> validEmployees) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine();
            System.out.println("Header: " + header);

            String line;
            while ((line = br.readLine()) != null) {
                // Split by comma and remove spaces
                String[] record = line.split(",\\s*");

                if (record.length < 5) {
                    System.out.println("Invalid row (Missing data): " + line);
                    continue;
                }

                String email = record[2];
                String phone = record[3];

                // Validate email, phone number
                if (!isValidEmail(email)) {
                    System.out.println("Invalid email format: " + email);
                    continue;
                }
                if (!isValidPhoneNumber(phone)) {
                    System.out.println("Invalid phone number: " + phone);
                    continue;
                }
                //add in employee record
                validEmployees.add(record);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: CSV file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error: Problem reading the file!");
            e.printStackTrace();
        }
    }
    // Method to validate email format
    public static boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailPattern);
    }
    // Method to validate phone number
    public static boolean isValidPhoneNumber(String phone) {
        String phonePattern = "^\\d{10}$";
        return phone.matches(phonePattern);
    }
}

package com.io_programming.advanced_problems.convert_csvdata_into_java_objects;
import java.io.*;
import java.util.*;
public class ConvertCsvDataIntoJavaObjects {
    public static void main(String[] args) {
        String filename = "src/sample2.txt";
        List<Student> students = readCsvToStudents(filename);
        printStudents(students);
    }
    // Method to read CSV and convert rows into Student objects
    public static List<Student> readCsvToStudents(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                // Split by comma and remove spaces
                String[] record = line.split(",\\s*");

                if (record.length < 4) { // Ensure correct column count
                    System.out.println("Invalid row (Missing data): " + line);
                    continue;
                }

                try {
                    String id = record[0];
                    String name = record[1];
                    // Convert age to integer
                    int age = Integer.parseInt(record[2].trim());
                    // Convert marks to integer
                    int marks = Integer.parseInt(record[3].trim());

                    Student student = new Student(id, name, age, marks);
                    students.add(student);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in row: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: CSV file not found!");
        } catch (IOException e) {
            System.out.println("Error: Problem reading the file!");
        }
        return students;
    }
    // Method to print the list of Student objects
    public static void printStudents(List<Student> students) {
        System.out.println("\nStudent List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

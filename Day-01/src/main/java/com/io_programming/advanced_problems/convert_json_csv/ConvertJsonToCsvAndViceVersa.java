package com.io_programming.advanced_problems.convert_json_csv;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.CDL;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertJsonToCsvAndViceVersa {
    public static void main(String[] args) {
        String jsonFile = "src/students";
        String csvFile = "src/sample4";
        String outputJsonFile = "students_output.json";

        convertJsonToCsv(jsonFile, csvFile);
        convertCsvToJson(csvFile, outputJsonFile);
    }

    // Method to convert JSON to CSV
    public static void convertJsonToCsv(String jsonFile, String csvFile) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(jsonFile)));
            JSONArray jsonArray = new JSONArray(jsonData);

            String csvData = CDL.toString(jsonArray);

            Files.write(Paths.get(csvFile), csvData.getBytes());
            System.out.println("JSON converted to CSV successfully: " + csvFile);
        } catch (Exception e) {
            System.out.println("Error converting JSON to CSV: " + e.getMessage());
        }
    }

    // Method to convert CSV to JSON
    public static void convertCsvToJson(String csvFile, String outputJsonFile) {
        try {
            String csvData = new String(Files.readAllBytes(Paths.get(csvFile)));
            JSONArray jsonArray = CDL.toJSONArray(csvData);

            Files.write(Paths.get(outputJsonFile), jsonArray.toString(4).getBytes());
            System.out.println("CSV converted to JSON successfully: " + outputJsonFile);
        } catch (Exception e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
}




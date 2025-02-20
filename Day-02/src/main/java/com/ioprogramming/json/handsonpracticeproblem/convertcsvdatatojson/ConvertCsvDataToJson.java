package com.ioprogramming.json.handsonpracticeproblem.convertcsvdatatojson;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

    public class ConvertCsvDataToJson {
        public static void main(String[] args) {
            String csvFilePath = "src/sample.csv";
            String jsonFilePath = "src/data.json";

            convertCsvToJson(csvFilePath, jsonFilePath);
        }

        public static void convertCsvToJson(String csvFile, String jsonFile) {
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                String line;
                String[] headers = br.readLine().split(",");

                JSONArray jsonArray = new JSONArray();

                // Read each line and convert to JSON
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    JSONObject jsonObject = new JSONObject();

                    for (int i = 0; i < headers.length; i++) {
                        jsonObject.put(headers[i].trim(), values[i].trim());
                    }
                    jsonArray.put(jsonObject);
                }
                // Save JSON to file
                Files.write(Paths.get(jsonFile), jsonArray.toString(4).getBytes(StandardCharsets.UTF_8));
                System.out.println(" JSON file saved at: " + jsonFile);

            } catch (Exception e) {
                System.out.println("Error converting CSV to JSON: " + e.getMessage());
            }
        }
    }

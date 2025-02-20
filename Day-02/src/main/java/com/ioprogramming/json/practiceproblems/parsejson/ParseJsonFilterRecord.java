package com.ioprogramming.json.practiceproblems.parsejson;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.File;

public class ParseJsonFilterRecord {
    public static void main(String[] args) {
        // File path to JSON file
        String filePath = "src/sample3.json";

        // Parse and filter JSON from file
        String filteredJson = parseAndFilterJson(filePath, 25);

        // Print filtered JSON
        System.out.println(filteredJson);
    }

    // Method to read JSON from file
    public static String parseAndFilterJson(String filePath, int minAge) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            if (rootNode.isArray()) {
                ArrayNode filteredArray = objectMapper.createArrayNode();

                for (JsonNode node : rootNode) {
                    if (node.has("age") && node.get("age").asInt() > minAge) {
                        // Add only records where age > minAge
                        filteredArray.add(node);
                    }
                }
                // Convert filtered data to JSON
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "[]";
    }
}


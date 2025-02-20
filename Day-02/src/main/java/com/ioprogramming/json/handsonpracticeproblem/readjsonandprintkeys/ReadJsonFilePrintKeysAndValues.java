package com.ioprogramming.json.handsonpracticeproblem.readjsonandprintkeys;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonFilePrintKeysAndValues {
    public static void main(String[] args) {
        //file path
        String filePath = "src/sample3.json";
        printJson(filePath);
    }

    public static void printJson(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(new File(filePath));

            // Print all keys and values
            printNode(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printNode(JsonNode node) {
        if (node.isObject()) {
            //iterator to iterate on map
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                System.out.println(field.getKey() + " = " + field.getValue());
                //recursively print
                printNode(field.getValue());
            }
        } else if (node.isArray()) {
            for (JsonNode item : node) {
                // Print each item in the array
                printNode(item);
            }
        }
    }
}


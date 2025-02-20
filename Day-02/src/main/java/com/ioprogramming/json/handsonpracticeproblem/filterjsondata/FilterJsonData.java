package com.ioprogramming.json.handsonpracticeproblem.filterjsondata;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;

public class FilterJsonData{
    public static void main(String[] args) {
        //file path
        String filePath = "src/sample3.json";
        //call the method
        filterUsersByAge(filePath);
    }
    //method to filter the user
    public static void filterUsersByAge(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(new File(filePath));

            if (root.isArray()) {
                //json is in array format check
                for (JsonNode user : root) {
                    JsonNode ageNode = user.get("age");
                    JsonNode nameNode = user.get("name");
                    if (ageNode != null && nameNode != null && ageNode.asInt() > 25) {
                        //prints only the users(name)
                        System.out.println(nameNode.asText());
                    }
                }
            } else {
                System.out.println("Invalid JSON format! Expected an array.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        }
    }
}

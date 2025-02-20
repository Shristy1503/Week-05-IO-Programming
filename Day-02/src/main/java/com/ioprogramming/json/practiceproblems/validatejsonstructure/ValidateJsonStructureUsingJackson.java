package com.ioprogramming.json.practiceproblems.validatejsonstructure;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ValidateJsonStructureUsingJackson {
    public static void main(String[] args) {
        //file path
        String json = "src/sample.json";
     //call method to check if valid
        if (isValidJson(json)) {
            System.out.println("Valid JSON");
        } else {
            System.out.println("Invalid JSON");
        }
    }

    public static boolean isValidJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parses JSON to check validity
            objectMapper.readTree(new File(json));
            return true;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
    }
}


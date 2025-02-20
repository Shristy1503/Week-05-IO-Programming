package com.ioprogramming.json.handsonpracticeproblem.validateemailfield;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileInputStream;

public class ValidateEmailFieldUsingJsonSchema {
        public static void main(String[] args)  {
            String jsonFilePath = "src/user.json";
            String schemaFilePath = "src/schema.json";
           //call method
            validateJson(jsonFilePath, schemaFilePath);
        }

        public static void validateJson(String jsonFile, String schemaFile) {
            try {
                // Load JSON data as an Object (not an array)
                JSONObject jsonData = new JSONObject(new JSONTokener(new FileInputStream(new File(jsonFile))));

                // Load JSON schema
                JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(new File(schemaFile))));
                Schema schema = SchemaLoader.load(jsonSchema);

                // Validate JSON against schema
                schema.validate(jsonData);
                System.out.println("Valid JSON for: " + jsonData.get("name"));
            } catch (Exception e) {
                System.out.println("Invalid JSON: " + e.getMessage());
            }
        }
    }


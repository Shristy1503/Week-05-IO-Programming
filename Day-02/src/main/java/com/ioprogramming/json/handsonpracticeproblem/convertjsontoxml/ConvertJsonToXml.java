package com.ioprogramming.json.handsonpracticeproblem.convertjsontoxml;
import org.json.JSONObject;
import org.json.XML;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertJsonToXml {
    public static void main(String[] args) {
        String jsonFilePath = "src/sample4.json";
        String xmlFilePath = "src/sample.xml";

        convertJsonToXml(jsonFilePath, xmlFilePath);
    }

    public static void convertJsonToXml(String jsonFile, String xmlFile) {
        try {
            // Read JSON file
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFile)), StandardCharsets.UTF_8);

            // Convert JSON to JSONObject
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Convert JSONObject to XML
            String xmlContent = XML.toString(jsonObject, "root");

            // Save XML to file
            Files.write(Paths.get(xmlFile), xmlContent.getBytes(StandardCharsets.UTF_8));
            System.out.println(" XML file saved at: " + xmlFile);

        } catch (Exception e) {
            System.out.println("Error converting JSON to XML: " + e.getMessage());
        }
    }
}

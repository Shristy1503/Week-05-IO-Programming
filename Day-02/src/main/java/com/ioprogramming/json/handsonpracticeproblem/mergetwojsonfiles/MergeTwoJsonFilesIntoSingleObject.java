package com.ioprogramming.json.handsonpracticeproblem.mergetwojsonfiles;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class MergeTwoJsonFilesIntoSingleObject {
    public static void main(String[] args) {
        String file1 = "src/user.json";
        String file2 = "src/user2.json";
        String mergedFile = "src/merged.json";

        mergeJsonFiles(file1, file2, mergedFile);
    }

    public static void mergeJsonFiles(String file1, String file2, String outputFile) {
        try {
            // Read JSON files
            String content1 = new String(Files.readAllBytes(Paths.get(file1)), StandardCharsets.UTF_8);
            String content2 = new String(Files.readAllBytes(Paths.get(file2)), StandardCharsets.UTF_8);

            // Convert to JSONObject
            JSONObject json1 = new JSONObject(content1);
            JSONObject json2 = new JSONObject(content2);

            // Merge JSON objects
            for (String key : json2.keySet()) {
                json1.put(key, json2.get(key));
            }

            // Save to file
            Files.write(Paths.get(outputFile), json1.toString(4).getBytes(StandardCharsets.UTF_8));
            System.out.println("Merged JSON saved to: " + outputFile);

        } catch (Exception e) {
            System.out.println("Error merging JSON files: " + e.getMessage());
        }
    }
}

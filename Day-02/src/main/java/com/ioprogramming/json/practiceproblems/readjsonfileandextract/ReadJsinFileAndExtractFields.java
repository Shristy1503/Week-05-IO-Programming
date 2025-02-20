package com.ioprogramming.json.practiceproblems.readjsonfileandextract;
import org.json.JSONObject;
import java.nio.file.*;

public class ReadJsinFileAndExtractFields {
    public static void main(String[] args) {
     String file = "src/sample.json";
     //call the method
     extractFields(file);
    }
    //method to read and write in file
    public static void extractFields(String file){
        try{
            //create path object that point to file and convert into string
            String data = new String(Files.readAllBytes(Paths.get("src/sample.json")));
            //convert data into json object
            JSONObject object = new JSONObject(data);
            //extract the specific fields
            //retrives value associated with key name and email
            String name = object.getString("name");
            String email = object.getString("email");

            //print
            System.out.println("name:" + name);
            System.out.println("email: " + email);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

package com.io_programming.intermediate_problems.search_fora_record;
import java.io.*;
import java.util.*;
public class SearchARecordInCsv {
    public static void main(String[] args) {
        String file = "src/employees";
        //call method
        searchRecord(file);
    }
    public static void searchRecord(String file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            //read file line by line
            while ((line = br.readLine()) != null) {
                //split line in comma based
                String[] records = line.split(",");
                if (records[1].trim().equals("Arjun") && index > 0) {
                    System.out.println(records[2] + records[3]);
                }
                index++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

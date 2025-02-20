package com.io_programming.intermediate_problems.filter_records;
import java.io.*;
import java.util.*;
public class FilterRecordsFromCsv {
    public static void main(String[] args) {
        String file = "src/sample2.txt";
        //call method
        filterRecords(file);
    }
    //method to filter records
    public static void filterRecords(String file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            int index = 0;
            //read file line by line
            while ((line = br.readLine()) != null){
                //split line in comma based
                String[] records = line.split(",");
                //try block to parse the string value to int value
                try {
                    //check marks and trim the record
                    if(Integer.parseInt(records[3].trim()) > 80 && index > 0){
                        System.out.println(records[0] + records[1] + records[2] + records[3]);
                    }
                }catch (NumberFormatException e){
                    e.getMessage();
                }
                index++;
            }
        }
        catch (IOException e){
        e.printStackTrace();
        }
    }
}

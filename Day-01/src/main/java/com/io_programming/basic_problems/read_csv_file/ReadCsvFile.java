package com.io_programming.basic_problems.read_csv_file;
import java.io.*;
import java.util.*;
public class ReadCsvFile {
    public static void main(String[] args) {
      String file = "src/sample2.txt";
      //call method to read file
      readFile(file);
    }

    //method to read csv file
    public static void readFile(String file){
       try (BufferedReader br = new BufferedReader(new FileReader(file))){
           String line;
           while ((line = br.readLine()) != null){
               //split the line into an array on commas
               String[] columns = line.split(",");
               System.out.println( columns[0] + "   " + columns[1] + "  " + columns[2] + "   " + columns[3]);
           }
       }
       catch (IOException e){
           //handle the IOException
            e.printStackTrace();
       }
    }
}

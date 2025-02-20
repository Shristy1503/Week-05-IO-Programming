package com.io_programming.basic_problems.read_and_count_rows;
import java.io.*;
import java.util.*;
public class ReadAndCountRowsInFile {
    public static void main(String[] args) {
       String file = "src/sample2.txt";
       //call method
        int result = countRows(file);
        System.out.println("Number of rows are: " + result);
    }
    //method to count rows in csv file
    public static int countRows(String file){
        //count variable to keep track of rows
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String row;
            //read file line by line
            while ((row = br.readLine()) != null){
                count++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //return row number
        return count;
    }
}

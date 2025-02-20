package com.io_programming.intermediate_problems.modify_csv_file;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ModifyaCsvFile {
    public static void main(String[] args) {
        //source file
        String file1 = "src/employees";
        //destination file
        String file2 = "src/employees2";
        //call method to modify the file records
        modifyFile(file1, file2);
        System.out.println("Updates save d in: " + file2);
    }
    //method to modify the file(read and write)
    public static void modifyFile(String file1, String file2){
        //read and write using buffer
       try (BufferedReader br = new BufferedReader(new FileReader(file1));
       BufferedWriter bw = new BufferedWriter(new FileWriter(file2))){
         String line;
         //read the file line by line
         while ((line = br.readLine()) != null){
             String[] record = line.split(",");
             try{
                 if(record[2].trim().equals("IT")){
                     //cinvert salary from string to integer
                     double salary = Double.parseDouble(record[3].trim());
                     //call updated salary method
                     int  newSalary = (int) updatedSalary(salary);
                     bw.write(record[0] + " " + record[1] + " " + record[2] + " " + newSalary);
                     bw.newLine();
                 }else{
                     bw.write(record[0] + " " + record[1] + " " + record[2] + " " + record[3]);
                     bw.newLine();
                 }
             }catch (NumberFormatException e){
                 e.getMessage();
             }

         }
       }
       catch (IOException e){
           e.printStackTrace();
       }
    }

    public static double updatedSalary(double salary){
       return salary*1.10;
    }
}

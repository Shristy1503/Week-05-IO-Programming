package com.io_programming.basic_problems.write_data_to_csv_file;
import java.io.*;
import java.util.*;
public class WriteDataToCsvFile {
    public static void main(String[] args) {
        String file = "src/sample.txt";
        //call method
        writeData(file);
    }
    //method to rite data in csv file
    public static void writeData( String file){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            //write in the file using bufferwriter
            bw.write(("ID,Name,Department,Salary\n"));
            bw.write("101, Arjun, HR, 54000\n");
            bw.write("102, Shristy, IT, 50000\n");
            bw.write("103, Tata, Finance, 45000\n");
            System.out.println("CSV FILE written\n");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

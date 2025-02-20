package com.io_programming.advanced_problems.encrypt_decrypt_csvdata;
import java.io.*;
import java.util.*;
import javax.crypto.*;

public class EncryptAndDecryptCsvData {
    private static SecretKey secretKey;

    public static void main(String[] args) {
        try {
            secretKey = generateKey();
            String encryptedFile = "encrypted_employees.csv";
            String decryptedFile = "decrypted_employees.csv";

            processEncryptionDecryption(encryptedFile, decryptedFile);
        } catch (Exception e) {
            System.err.println("Error in main execution: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // This function does both encryption (writes CSV) and decryption (reads CSV)
    public static void processEncryptionDecryption(String encryptedFile, String decryptedFile) {
        try {
            // Sample data
            List<String[]> employees = Arrays.asList(
                    new String[]{"ID", "Name", "Department", "Salary", "Email"},
                    new String[]{"101", "Arjun", "HR", "54000", "arjun@example.com"},
                    new String[]{"102", "Shristy", "IT", "60000", "shristy@example.com"},
                    new String[]{"103", "Tata", "Finance", "45000", "tata@example.com"}
            );

            // Encrypt & write CSV
            writeEncryptedCSV(employees, encryptedFile);

            // Read & decrypt CSV
            readAndDecryptCSV(encryptedFile, decryptedFile);
        } catch (Exception e) {
            System.err.println("Error in processing: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Generate AES key
    private static SecretKey generateKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            return keyGen.generateKey();
        } catch (Exception e) {
            System.err.println("Error generating AES key: " + e.getMessage());
            return null;
        }
    }

    // Encrypt and write CSV, then decrypt it
    private static void writeEncryptedCSV(List<String[]> data, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String[] record : data) {
                // Encrypt Salary & Email (skip header)
                if (!record[0].equals("ID")) {
                    record[3] = encrypt(record[3]); // Encrypt Salary
                    record[4] = encrypt(record[4]); // Encrypt Email
                }
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Encrypted CSV file written successfully: " + filename);
        } catch (Exception e) {
            System.err.println("Error encrypting CSV: " + e.getMessage());
        }
    }

    // Read, decrypt, and write CSV
    private static void readAndDecryptCSV(String inputFilename, String outputFilename) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilename));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilename))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(",");
                if (!record[0].equals("ID")) {
                    record[3] = decrypt(record[3]); // Decrypt Salary
                    record[4] = decrypt(record[4]); // Decrypt Email
                }
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Decrypted CSV file written successfully: " + outputFilename);
        } catch (Exception e) {
            System.err.println("Error decrypting CSV: " + e.getMessage());
        }
    }

    // Encrypt a string using AES
    private static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            System.err.println("Error encrypting data: " + e.getMessage());
            return null;
        }
    }

    // Decrypt a string using AES
    private static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes);
        } catch (Exception e) {
            System.err.println("Error decrypting data: " + e.getMessage());
            return null;
        }
    }
}

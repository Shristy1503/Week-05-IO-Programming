package com.ioprogramming.json.handsonpracticeproblem.generatejsonreport;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateJsonReportFromDatabase {
    public static void main(String[] args) {
        String jsonFile = "src/file.json";
        exportDataToJson(jsonFile);
    }

    public static void exportDataToJson(String jsonFile) {
        String url = "jdbc:mysql://localhost:3306/my_database";
        String user = "shristy_015";
        String password = "password";

        String query = "SELECT id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            List<Map<String, Object>> employeeList = new ArrayList<>();

            while (rs.next()) {
                Map<String, Object> employee = new HashMap<>();
                employee.put("ID", rs.getInt("id"));
                employee.put("Name", rs.getString("name"));
                employee.put("Department", rs.getString("department"));
                employee.put("Salary", rs.getDouble("salary"));

                employeeList.add(employee);
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(jsonFile), employeeList);

            System.out.println("Employee data exported to JSON: " + jsonFile);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


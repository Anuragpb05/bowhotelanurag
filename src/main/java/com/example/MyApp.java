package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyApp {

    public static void main(String[] args) {
        // Performance Issue: Inefficient database query
        System.out.println("Starting database query...");
        queryDatabase();

        // Security Issue: Unsanitized input
        String userInput = "SELECT * FROM users WHERE username = 'admin'; --";
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        System.out.println("Executing unsafe query: " + query);

        // Code Quality Issue: Redundant method calls
        String result = getMessage();
        System.out.println(result);
    }

    // Inefficient method: Iterating over the same data multiple times.
    public static void queryDatabase() {
        try {
            // Simulating a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users"; // inefficient query
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Redundant method: Repeating a static message unnecessarily.
    public static String getMessage() {
        return "Hello from MyApp!";
    }
}

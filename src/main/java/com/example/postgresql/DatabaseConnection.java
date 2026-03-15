package com.example.postgresql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles PostgreSQL database connection
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/campusmart";
    private static final String USER = "vishnu";
    private static final String PASSWORD = "vishnu1206";

    /**
     * Returns a connection to the database
     */
    public static Connection getConnection() throws SQLException {
        System.out.println("[INFO] Connecting to database...");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("[INFO] Connected successfully!");
        return conn;
    }
}
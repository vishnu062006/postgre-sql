package com.example.postgresql;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Handles DDL operations - CREATE, DROP tables
 */
public class DDLExecutor {

    /**
     * Creates the products table
     */
    public void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS products (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    price DOUBLE PRECISION NOT NULL
                )
                """;
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("[INFO] Table 'products' created successfully");
        } catch (SQLException e) {
            System.out.println("[ERROR] DDL failed: " + e.getMessage());
        }
    }

    /**
     * Drops the products table
     */
    public void dropTable() {
        String sql = "DROP TABLE IF EXISTS products";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("[INFO] Table 'products' dropped successfully");
        } catch (SQLException e) {
            System.out.println("[ERROR] Drop failed: " + e.getMessage());
        }
    }
}
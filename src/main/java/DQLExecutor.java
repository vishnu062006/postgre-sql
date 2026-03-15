import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DQLExecutor {
    public void getAllProducts() {
        String sql = "SELECT * FROM products";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("[INFO] All products:");
            while (rs.next()) {
                System.out.println("  ID: " + rs.getInt("id")
                        + " | Name: " + rs.getString("name")
                        + " | Price: " + rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println("[ERROR] Select failed: " + e.getMessage());
        }
    }
    public void getProductById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("[INFO] Found product:");
                System.out.println("  ID: " + rs.getInt("id")
                        + " | Name: " + rs.getString("name")
                        + " | Price: " + rs.getDouble("price"));
            } else {
                System.out.println("[WARN] Product not found: ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("[ERROR] Select failed: " + e.getMessage());
        }
    }
}
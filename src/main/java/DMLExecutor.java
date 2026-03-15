import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DMLExecutor {
    public void insertProduct(String name, double price) {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.executeUpdate();
            System.out.println("[INFO] Product inserted: " + name);
        } catch (SQLException e) {
            System.out.println("[ERROR] Insert failed: " + e.getMessage());
        }
    }
    public void updateProduct(int id, double newPrice) {
        String sql = "UPDATE products SET price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, newPrice);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("[INFO] Product updated: ID " + id);
        } catch (SQLException e) {
            System.out.println("[ERROR] Update failed: " + e.getMessage());
        }
    }
    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("[INFO] Product deleted: ID " + id);
        } catch (SQLException e) {
            System.out.println("[ERROR] Delete failed: " + e.getMessage());
        }
    }
}
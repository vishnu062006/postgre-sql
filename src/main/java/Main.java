public class Main {
    public static void main(String[] args) {
        DDLExecutor ddl = new DDLExecutor();
        DMLExecutor dml = new DMLExecutor();
        DQLExecutor dql = new DQLExecutor();

        System.out.println("\n--- DDL: CREATE TABLE ---");
        ddl.createTable();

        System.out.println("\n--- DML: INSERT ---");
        dml.insertProduct("Laptop", 45000);
        dml.insertProduct("Phone", 20000);
        dml.insertProduct("Tablet", 30000);

        System.out.println("\n--- DQL: SELECT ALL ---");
        dql.getAllProducts();

        // DQL - read one
        System.out.println("\n--- DQL: SELECT ONE ---");
        dql.getProductById(1);

        // DML - update
        System.out.println("\n--- DML: UPDATE ---");
        dml.updateProduct(1, 40000);

        // DQL - verify update
        System.out.println("\n--- DQL: VERIFY UPDATE ---");
        dql.getProductById(1);

        // DML - delete
        System.out.println("\n--- DML: DELETE ---");
        dml.deleteProduct(2);

        // DQL - verify delete
        System.out.println("\n--- DQL: VERIFY DELETE ---");
        dql.getAllProducts();

        // DDL - drop table
        System.out.println("\n--- DDL: DROP TABLE ---");
        ddl.dropTable();
    }
}
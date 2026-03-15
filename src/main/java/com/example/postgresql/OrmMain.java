package com.example.postgresql;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Main class demonstrating ORM with Spring Data JPA
 */
@SpringBootApplication
public class OrmMain {

    public static void main(String[] args) {
        SpringApplication.run(OrmMain.class, args);
    }

    @Bean
    CommandLineRunner demo(ProductRepository repo) {
        return args -> {

            // CREATE
            System.out.println("\n--- ORM: INSERT ---");
            repo.save(new ProductEntity("Laptop", 45000.0));
            repo.save(new ProductEntity("Phone", 20000.0));
            repo.save(new ProductEntity("Tablet", 30000.0));

            // READ ALL
            System.out.println("\n--- ORM: SELECT ALL ---");
            repo.findAll().forEach(p -> System.out.println(p));

            // READ ONE
            System.out.println("\n--- ORM: SELECT ONE ---");
            repo.findById(1).ifPresent(p -> System.out.println(p));

            // UPDATE
            System.out.println("\n--- ORM: UPDATE ---");
            repo.findById(1).ifPresent(p -> {
                p.setPrice(40000.0);
                repo.save(p);
                System.out.println("Updated: " + p);
            });

            // DELETE
            System.out.println("\n--- ORM: DELETE ---");
            repo.deleteById(2);
            System.out.println("Deleted product ID 2");

            // VERIFY
            System.out.println("\n--- ORM: VERIFY ---");
            repo.findAll().forEach(p -> System.out.println(p));
        };
    }
}
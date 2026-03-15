package com.example.postgresql;
import jakarta.persistence.*;
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    public ProductEntity() { }

    public ProductEntity(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name=" + name + ", price=" + price + "}";
    }
}
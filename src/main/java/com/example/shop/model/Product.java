package com.example.shop.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Lombok:
 * Generates boilerplate code like getters, setters, constructors automatically.
 * Helps keep the class clean and readable.
 */

@Getter // Generates all getter methods
@Setter // Generates all setter methods
@NoArgsConstructor // Required by JPA (empty constructor)
@AllArgsConstructor // Constructor with all fields
@Entity // Marks this class as a database entity (table)
public class Product {

    // Primary key
    @Id

    // Auto-increment ID handled by database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Product name (e.g., "Running Shoes")
    private String name;

    // Brand name (e.g., "Nike")
    private String brand;

    // Product description
    private String description;

    // Price (BigDecimal used for accurate financial calculations)
    private BigDecimal price;

    // Available stock quantity
    private int inventory;

    /*
     * Many products can belong to one category
     *
     * IMPORTANT:
     * Avoid CascadeType.ALL here in most cases
     * because deleting a product might delete the category too
     * FetchType.LAZY → category is loaded only when needed (better performance)
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id") // Foreign key column
    private Category category;

    /*
     * One product can have multiple images
     *
     * mappedBy = "product"
     * → refers to 'product' field in Image class
     *
     * cascade = CascadeType.ALL
     * → saving/deleting product affects images
     *
     * orphanRemoval = true
     * → removing image from list deletes it from DB
     */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;
}
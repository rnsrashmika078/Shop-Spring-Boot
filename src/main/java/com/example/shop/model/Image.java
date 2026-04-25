package com.example.shop.model;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Lombok is a Java library that automatically generates boilerplate code
 * like getters, setters, constructors, etc. at compile time.
 *
 * Without Lombok, you would manually write:
 * - getters
 * - setters
 * - constructors
 *
 * With Lombok → less code, cleaner classes 
 */

// Generates getter methods for all fields (getId(), getName(), etc.)
@Getter

// Generates setter methods for all fields (setId(), setName(), etc.)
@Setter

// Generates a constructor with all fields as parameters
@AllArgsConstructor

// Generates a default (no-argument) constructor (required by JPA)
@NoArgsConstructor

// Marks this class as a JPA entity → will map to a database table
@Entity
public class Image {

    // Primary key of the table
    @Id
    // Auto-increment ID (handled by the database)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the image file (e.g., "shoe.png")
    private String name;

    // File type (e.g., "image/png", "image/jpeg")
    private String fileType;

    // Marks this field as a Large Object (for storing large binary data)
    @Lob
    // Stores actual image data in binary format inside DB
    @Column(name = "image_data")
    private byte[] imageData;

    // URL used to download or access the image
    private String downloadUrl;

    // Many images can belong to one product (relationship)
    @ManyToOne

    // Foreign key column that links to Product table
    @JoinColumn(name = "product_id")
    private Product product;
}
package com.example.shop.request;

import java.math.BigDecimal;

import com.example.shop.model.Category;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ProductUpdateRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String brand;

    private BigDecimal price;

    private int inventory;

    private Category category;

    private String description;

}

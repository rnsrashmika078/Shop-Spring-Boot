package com.example.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByCategoryName(String category);

    Category findAByBrand(String brand);

    Category findByCategoryNameAndBrand(String category, String brand);

    Category findByName(String name);

    Category findByBrandAndName(String name, String brand);

    Long countByBrandAndName(String brand, String name);

}

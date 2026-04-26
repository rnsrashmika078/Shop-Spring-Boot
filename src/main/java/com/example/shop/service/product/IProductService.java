package com.example.shop.service.product;

import java.util.List;
import com.example.shop.model.Product;
import com.example.shop.request.AddProductRequest;
import com.example.shop.request.ProductUpdateRequest;

public interface IProductService {
    Product addProduct(AddProductRequest product);

    Product getProductById(Long id);

    void deleteProductById(Long id);

    Product updateProductById(ProductUpdateRequest product, Long productId);

    List<Product> getAllProducts();

    List<Product> getAllProductsByCategory(String category);

    List<Product> getProductByBrand(String brand);

    List<Product> getProductByCategoryAndBrand(String category, String brand);

    List<Product> getProductByName(String name);

    List<Product> getProductByBrandAndName(String brand, String name); // highlighted

    Long countProductByBrandAndName(String brand, String name);

}

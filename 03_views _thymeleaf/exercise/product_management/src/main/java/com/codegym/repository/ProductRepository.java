package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProduct();
    Product selectProductById(Integer id);
    void saveProduct(Product product);
    void deleteProduct(Integer id);
    List<Product> searchProductName(String name);
}

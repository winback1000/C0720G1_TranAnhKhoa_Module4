package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    Product selectProductById(int id);
    void addProduct(Product product);
    void deleteProduct(int id);
    void deleteProduct(Product product);
    List<Product> searchProductByNameAndManufacturer(String searchData);
}

package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProduct();
    Product selectProductById(Integer id);
    void addProduct(Product product);
    void deleteProduct(int id);
    void editProduct(Product product);
    List<Product> searchProduct(String name);
}

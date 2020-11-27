package com.codegym.service.implement;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public Product selectProductById(Integer id) {
        return productRepository.selectProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public void editProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public List<Product> searchProduct(String name) {
        return productRepository.searchProductName(name);
    }
}

package com.codegym.service.implement;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    
    static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product("Galaxy S1","Samsung" , 100d,10));
        productList.add(new Product("Galaxy S2","Samsung" , 200d,10));
        productList.add(new Product("Galaxy S3","Samsung" , 300d,10));
        productList.add(new Product("Galaxy S4","Samsung" , 400d,10));
        productList.add(new Product("Galaxy S5","Samsung" , 500d,10));
        productList.add(new Product("Galaxy S6","Samsung" , 600d,10));
    }
    @Override
    public List<Product> getAllProduct() {
        return productList;
    }

    @Override
    public Product selectProductById(int id) {
        Product prd = null;
        for (Product product: productList) {
            if(product.getId() == id) {
                prd = product;
            }
        } return prd;
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void deleteProduct(int id) {
        productList.removeIf(product -> product.getId() == id);
    }

    @Override
    public void editProduct(Product product) {
        for (Product prd: productList) {
            if(prd.getId() == product.getId()) {
                prd.setName(product.getName());
                prd.setManufacturer(product.getManufacturer());
                prd.setPrice(product.getPrice());
                prd.setStock(product.getStock());
            }
        }
    }

    @Override
    public List<Product> searchProduct(String name) {
        List<Product> searchResult = new ArrayList<>();
        for (Product prd: productList) {
            if(prd.getName().contains(name)) {
                searchResult.add(prd);
            }
        } return searchResult;
    }
}

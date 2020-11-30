package com.codegym.service.implement;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.findAll();
    }

    @Override
    public Product selectProductById(int id) {
        return iProductRepository.getOne(id);
    }

    @Override
    public void addProduct(Product product) {
        iProductRepository.save(product);
    }


    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public void deleteProduct(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public List<Product> searchProductByNameAndManufacturer(String searchData) {
        return iProductRepository.findAllByNameContainsOrManufacturerContains(searchData,searchData);
    }


}

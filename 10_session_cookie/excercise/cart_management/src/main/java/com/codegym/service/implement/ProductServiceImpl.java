package com.codegym.service.implement;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.getOne(id);
    }
}

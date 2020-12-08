package com.codegym.service.implement;

import com.codegym.model.CartProduct;
import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.repository.IProductRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void addProductToCustomer(Integer customerId, Integer productId) {
        Customer customer = iCustomerRepository.findById(customerId).orElse(null);
        assert customer != null;
        customer.getUnpaidCart().getCardProductList().add(new CartProduct(null, customer.getUnpaidCart(),iProductRepository.getOne(productId),1));
        iCustomerRepository.save(customer);
    }
}

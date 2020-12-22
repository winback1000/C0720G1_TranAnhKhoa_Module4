package com.codegym.service.implement;

import com.codegym.entity.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer selectCustomerById(int id) {
        return customerRepository.getOne(id);
    }
}

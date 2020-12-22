package com.codegym.service;

import com.codegym.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    Customer selectCustomerById(int id);

}

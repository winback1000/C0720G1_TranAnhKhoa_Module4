package com.codegym.service;

import com.codegym.model.Customer;

public interface ICustomerService {
    Customer findById(int id);

    void addProductToCustomer(Integer customerId, Integer productId);
}

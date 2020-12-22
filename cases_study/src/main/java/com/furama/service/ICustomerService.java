package com.furama.service;

import com.furama.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer selectCustomerById(int id);

    Page<Customer> findAllWithPage(Pageable pageable);

    Page<Customer> searchCustomer(String searchData, Pageable pageable);

    void delete(int deleteID);

    void save(Customer customer);

}

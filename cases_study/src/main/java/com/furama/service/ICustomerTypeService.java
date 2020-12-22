package com.furama.service;

import com.furama.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
    CustomerType selectCustomerTypeById(int id);
}

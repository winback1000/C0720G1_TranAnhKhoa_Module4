package com.furama.service.implement;

import com.furama.entity.CustomerType;
import com.furama.repository.CustomerTypeRepository;
import com.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType selectCustomerTypeById(int id) {
        return customerTypeRepository.findById(id).orElse(null);
    }
}

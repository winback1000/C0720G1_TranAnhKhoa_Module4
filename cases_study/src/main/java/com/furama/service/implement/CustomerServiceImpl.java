package com.furama.service.implement;

import com.furama.entity.Customer;
import com.furama.repository.CustomerRepository;
import com.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAllWithPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> searchCustomer(String searchData, Pageable pageable) {
        return customerRepository.findAllByNameContainsOrEmailContains(searchData,searchData,pageable);
    }

    @Override
    public void delete(int deleteID) {
        customerRepository.deleteById(deleteID);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }


}

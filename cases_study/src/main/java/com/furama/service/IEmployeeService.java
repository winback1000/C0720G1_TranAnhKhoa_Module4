package com.furama.service;

import com.furama.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee selectEmployeeById(int id);
    Page<Employee> findAllWithPage(Pageable pageable);

    void save(Employee employee);

    void delete(int deleteID);

    Page<Employee> searchEmployee(String searchData, Pageable pageable);
}

package com.furama.service.implement;

import com.furama.entity.Employee;
import com.furama.repository.EmployeeRepository;
import com.furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee selectEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> findAllWithPage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int deleteID) {
        employeeRepository.deleteById(deleteID);
    }

    @Override
    public Page<Employee> searchEmployee(String searchData, Pageable pageable) {
        return employeeRepository.findAllByNameContainsOrEmailContains(searchData,searchData,pageable);
    }


}

package service;

import model.Employee;

import java.util.List;

public interface IEmployeeService {

    void addEmployee (Employee employee);
    List<Employee> getAllEmployee();
}

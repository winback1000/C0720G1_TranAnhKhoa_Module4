package service.implement;

import model.Employee;
import org.springframework.stereotype.Service;
import service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    static List<Employee> employeeList = new ArrayList<>();
    static {
        employeeList.add(new Employee(1,"Tu1","1A"));
        employeeList.add(new Employee(2,"Tu2","2A"));
        employeeList.add(new Employee(3,"Tu3","3A"));
        employeeList.add(new Employee(4,"Tu4","4A"));
        employeeList.add(new Employee(5,"Tu5","5A"));

    }
    @Override
    public void addEmployee(Employee employee) {
        employee.setId(employeeList.size()+1);
        employeeList.add(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }
}

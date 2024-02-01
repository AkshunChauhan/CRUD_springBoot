package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service annotation indicates that this class is a service component
@Service
public class EmployeeService {

    // injects the EmployeeRepository dependency
    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to save an employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Method to find an employee by ID
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    // Method to retrieve all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    // Method to delete an employee by ID
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}

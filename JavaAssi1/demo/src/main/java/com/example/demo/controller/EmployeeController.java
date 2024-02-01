package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create a new employee
    @PostMapping("/create")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        // Validate the input employee data and save it
        return employeeService.saveEmployee(employee);
    }

    // Retrieve all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        // Retrieve all employees from the database
        return employeeService.getAllEmployees();
    }

    // Retrieve a specific employee by ID
    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        // Validate the employee ID
        if (employeeId <= 0) {
            throw new IllegalArgumentException("Employee ID must be positive");
        }
        // Retrieve the employee by ID from the service layer
        Employee employee = employeeService.findById(employeeId);
        // Check if the employee exists
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeId);
        }
        return employee;
    }

    // Update an existing employee
    @PutMapping("/update/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @Valid @RequestBody Employee employee) {
        // Check if the employee exists
        Employee existingEmployee = employeeService.findById(employeeId);
        if (existingEmployee == null) {
            // Employee not found, throw an exception
            throw new EmployeeNotFoundException(employeeId);
        }
        // Ensure the correct ID is set and save the updated employee
        employee.setId(employeeId);
        return employeeService.saveEmployee(employee);
    }

    // Delete an employee by ID
    @DeleteMapping("/delete/{employeeId}")
    public HttpStatus deleteEmployee(@PathVariable int employeeId) {
        // Check if the employee exists
        Employee existingEmployee = employeeService.findById(employeeId);
        if (existingEmployee == null) {
            // Employee not found, return 404 NOT FOUND
            return HttpStatus.NOT_FOUND;
        }
        // Delete the employee and return 204 NO CONTENT upon successful deletion
        employeeService.deleteEmployee(employeeId);
        return HttpStatus.NO_CONTENT;
    }
}

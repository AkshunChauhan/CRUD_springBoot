package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Custom exception class to handle cases when an employee is not found
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

    // Constructor to create an exception with a message containing the employee ID
    public EmployeeNotFoundException(int employeeId) {
        // Call the superclass constructor with a message indicating the employee ID
        super("Employee not found with id: " + employeeId);
    }
}

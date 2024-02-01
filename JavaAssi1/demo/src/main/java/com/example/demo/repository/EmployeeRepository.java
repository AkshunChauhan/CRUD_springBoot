package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Repository annotation indicates that this class is a repository component
@Repository
public class EmployeeRepository {

    // List to store employees
    private final List<Employee> list = new ArrayList<>();

    // Method to retrieve all employees
    public List<Employee> getAllEmployees() {
        return list;
    }

    // Method to find an employee by ID
    public Employee findById(int id) {
        for (Employee e : list) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    // Method to save an employee
    public Employee save(Employee employee) {
        // Create a new Employee object and set its attributes
        Employee e = new Employee();
        e.setId(employee.getId());
        e.setName(employee.getName());
        e.setAge(employee.getAge());
        e.setAddress(employee.getAddress());

        // Add the new Employee object to the list
        list.add(e);

        // Return the saved Employee object
        return e;
    }

    // Method to delete an employee by ID
    public void deleteById(int employeeId) {
        // Use iterator to safely remove employee from the list
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == employeeId) {
                iterator.remove(); // Remove the employee from the list
            }
        }
    }
}

package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> list = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return list;
    }

    public Employee findById(int id) {
        for (Employee e : list) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public Employee save(Employee employee) {
        Employee e = new Employee();
        e.setId(employee.getId());
        e.setName(employee.getName());
        e.setAge(employee.getAge());
        e.setAddress(employee.getAddress());
        list.add(e);
        return e;
    }

    public void deleteById(int employeeId) {
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == employeeId) {
                iterator.remove();
            }
        }
    }
}

package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.entity.Employee;
import com.example.pizzanetwork.data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public int count() {
        return (int) employeeRepository.count();
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}

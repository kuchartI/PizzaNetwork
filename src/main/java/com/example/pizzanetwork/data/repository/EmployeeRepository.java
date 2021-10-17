package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

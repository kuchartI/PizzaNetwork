package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByNameContaining(String name);
}

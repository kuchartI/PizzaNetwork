package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.PizzaToppings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaToppingsRepository extends JpaRepository<PizzaToppings, Long> {
}

package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToppingRepository extends JpaRepository<Topping, Long> {
}

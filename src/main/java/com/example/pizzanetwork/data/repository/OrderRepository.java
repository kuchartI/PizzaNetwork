package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

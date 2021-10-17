package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.RestaurantPizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantPizzaRepository  extends JpaRepository<RestaurantPizza, Long> {
}

package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}

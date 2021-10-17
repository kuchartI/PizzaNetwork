package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

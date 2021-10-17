package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository  extends JpaRepository<Position, Long> {
}

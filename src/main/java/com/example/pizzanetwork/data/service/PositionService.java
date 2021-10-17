package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.entity.Position;
import com.example.pizzanetwork.data.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;
    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public int count() {
        return (int) positionRepository.count();
    }

    public void createPosition(Position position) {
        positionRepository.save(position);
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}

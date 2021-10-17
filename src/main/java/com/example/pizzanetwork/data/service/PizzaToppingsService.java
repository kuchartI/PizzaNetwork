package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.entity.PizzaToppings;
import com.example.pizzanetwork.data.repository.PizzaToppingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaToppingsService {


    private final PizzaToppingsRepository pizzaToppingsRepository;
    @Autowired
    public PizzaToppingsService(PizzaToppingsRepository pizzaToppingsRepository) {
        this.pizzaToppingsRepository = pizzaToppingsRepository;
    }

    public int count() {
        return (int) pizzaToppingsRepository.count();
    }

    public PizzaToppings findById(Long id) {
        return pizzaToppingsRepository.findById(id).orElse(null);
    }

    public List<PizzaToppings> findAll() {
        return pizzaToppingsRepository.findAll();
    }

    public void createPizzaToppings(PizzaToppings pizzaToppings) {
        pizzaToppingsRepository.save(pizzaToppings);
    }
}
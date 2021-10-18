package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.entity.PizzaOrder;
import com.example.pizzanetwork.data.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaOrderService {


    private final PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    public PizzaOrderService(PizzaOrderRepository pizzaOrderRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public int count() {
        return (int) pizzaOrderRepository.count();
    }

    public PizzaOrder findById(Long id) {
        return pizzaOrderRepository.findById(id).orElse(null);
    }

    public List<PizzaOrder> findAll() {
        return pizzaOrderRepository.findAll();
    }

    public void createPizzaOrder(PizzaOrder pizzaOrder) {
        pizzaOrderRepository.save(pizzaOrder);
    }
}

package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.entity.Topping;
import com.example.pizzanetwork.data.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService {

    private final ToppingRepository toppingRepository;

    @Autowired
    public ToppingService(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    public int count() {
        return (int) toppingRepository.count();
    }

    public Topping findById(Long id) {
        return toppingRepository.findById(id).orElse(null);
    }

    public List<Topping> findAll() {
        return toppingRepository.findAll();
    }

    public void createTopping(Topping topping) {
        toppingRepository.save(topping);
    }
}

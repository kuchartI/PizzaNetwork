package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.entity.RestaurantPizza;
import com.example.pizzanetwork.data.repository.RestaurantPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantPizzaService {


    private final RestaurantPizzaRepository restaurantPizzaRepository;
    @Autowired
    public RestaurantPizzaService(RestaurantPizzaRepository restaurantPizzaRepository) {
        this.restaurantPizzaRepository = restaurantPizzaRepository;
    }

    public int count() {
        return (int) restaurantPizzaRepository.count();
    }

    public RestaurantPizza findById(Long id) {
        return restaurantPizzaRepository.findById(id).orElse(null);
    }

    public List<RestaurantPizza> findAll() {
        return restaurantPizzaRepository.findAll();
    }

    public void createRestaurantPizzaService(RestaurantPizza restaurantPizza) {
        restaurantPizzaRepository.save(restaurantPizza);
    }

}

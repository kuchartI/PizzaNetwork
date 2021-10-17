package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.entity.Restaurant;
import com.example.pizzanetwork.data.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {


    private final RestaurantRepository restaurantRepository;
    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public int count() {
        return (int) restaurantRepository.count();
    }

    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}

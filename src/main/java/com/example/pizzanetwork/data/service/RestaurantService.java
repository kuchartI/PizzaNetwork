package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.dto.RestaurantDto;
import com.example.pizzanetwork.data.entity.Restaurant;
import com.example.pizzanetwork.data.repository.RestaurantRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RestaurantService {

    Logger logger = Logger.getLogger(RestaurantService.class);

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

    private RestaurantDto createRestaurantDto(Restaurant restaurant) {
        return new RestaurantDto(restaurant.getId(), restaurant.getAddress(), restaurant.getStart_of_work()
                , restaurant.getStart_of_work(), restaurant.getPhone());
    }

    @Cacheable("restaurantById")
    public RestaurantDto findRestaurantById(Integer id) {
        logger.info("find restaurant by id and cache");
        final var restaurant = restaurantRepository.getById((long) id);
        return createRestaurantDto(restaurant);
    }

    @Cacheable("restaurants")
    public List<RestaurantDto> findAll() {
        logger.info("find all restaurants and cache");
        final var result = restaurantRepository.findAll();
        return result.stream().map(this::createRestaurantDto).collect(Collectors.toList());
    }

    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}

package com.example.pizzanetwork.web.controllers;

import com.example.pizzanetwork.data.dto.OrderDto;
import com.example.pizzanetwork.data.dto.PizzaOrderDto;
import com.example.pizzanetwork.data.dto.RestaurantDto;
import com.example.pizzanetwork.data.service.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurant")
@Api("Restaurant api")
public class RestaurantController {
    private final RestaurantService restaurantService;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    @ApiOperation("Get all restaurant")
    public List<RestaurantDto> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    @ApiOperation("Get restaurant by id")
    public RestaurantDto findAllPizzasByOrderId(@PathVariable Integer id) {
        return restaurantService.findRestaurantById(id);
    }
}

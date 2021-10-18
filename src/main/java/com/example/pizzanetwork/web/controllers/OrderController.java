package com.example.pizzanetwork.web.controllers;

import com.example.pizzanetwork.data.dto.OrderDto;
import com.example.pizzanetwork.data.dto.PizzaOrderDto;
import com.example.pizzanetwork.data.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@Api("Pizza order api")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation("Get all orders")
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation("Get all pizza in order by id")
    public List<PizzaOrderDto> findAllPizzasByOrderId(@PathVariable Integer id) {
        return orderService.findAllPizzasByOrderId(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    @ApiOperation("Create order")
    public List<PizzaOrderDto> createOrder(@RequestBody @Valid List<PizzaOrderDto> pizzaOrderDto) {
        return orderService.createPizzaOrders(pizzaOrderDto);
    }
}

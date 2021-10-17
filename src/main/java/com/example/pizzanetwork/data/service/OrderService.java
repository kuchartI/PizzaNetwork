package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.dto.OrderDto;
import com.example.pizzanetwork.data.dto.PizzaOrderDto;
import com.example.pizzanetwork.data.entity.Order;
import com.example.pizzanetwork.data.entity.PizzaOrder;
import com.example.pizzanetwork.data.repository.OrderRepository;
import com.example.pizzanetwork.data.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, PizzaOrderRepository pizzaOrderRepository) {
        this.orderRepository = orderRepository;
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    public int count() {
        return (int) orderRepository.count();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    private OrderDto createOrderDto(Order order) {
        return new OrderDto(order.getId(), order.getRestaurant_id().getId(), order.getPrice(), order.getDate());
    }
    private PizzaOrderDto createPizzaOrderDto(PizzaOrder pizzaOrder) {
        return new PizzaOrderDto(pizzaOrder.getId(), pizzaOrder.getOrder_id().getId(), pizzaOrder.getPizza_id().getName());
    }
    public List<OrderDto> findAll() {
        final var result = orderRepository.findAll();
        return result.stream().map(this::createOrderDto).collect(Collectors.toList());
    }

    public List<PizzaOrderDto> findAllOrderById(Integer id) {
        final var result = pizzaOrderRepository.getAllByOrderId((long)id);
        return result.stream().map(this::createPizzaOrderDto).collect(Collectors.toList());
    }
}

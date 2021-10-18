package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.dto.OrderDto;
import com.example.pizzanetwork.data.dto.PizzaOrderDto;
import com.example.pizzanetwork.data.entity.Order;
import com.example.pizzanetwork.data.entity.PizzaOrder;
import com.example.pizzanetwork.data.repository.OrderRepository;
import com.example.pizzanetwork.data.repository.PizzaOrderRepository;
import com.example.pizzanetwork.data.repository.PizzaRepository;
import com.example.pizzanetwork.data.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaOrderRepository pizzaOrderRepository;
    private final PizzaRepository pizzaRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, PizzaOrderRepository pizzaOrderRepository,
                        PizzaRepository pizzaRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.pizzaRepository = pizzaRepository;
        this.restaurantRepository = restaurantRepository;
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
        return new PizzaOrderDto(pizzaOrder.getId(), pizzaOrder.getOrder_id().getId(), pizzaOrder.getPizza_id().getName()
                , pizzaOrder.getPizza_id().getId());
    }

    public List<OrderDto> findAll() {
        final var result = orderRepository.findAll();
        return result.stream().map(this::createOrderDto).collect(Collectors.toList());
    }

    public List<PizzaOrderDto> findAllPizzasByOrderId(Integer id) {
        final var result = pizzaOrderRepository.getAllByOrderId((long) id);
        return result.stream().map(this::createPizzaOrderDto).collect(Collectors.toList());
    }

    public List<PizzaOrderDto> createPizzaOrder(List<PizzaOrderDto> pizzaOrderDto) {
        var order = new Order();
        final BigDecimal[] price = {new BigDecimal(0)};
        Random random = new Random();
        order.setDate(new Date());
        pizzaOrderDto.forEach(it ->
        {
             price[0] = price[0].add(pizzaRepository.getById(it.getPizza_id()).getPrice());
        });
        order.setPrice(price[0]);
        order.setRestaurant_id(restaurantRepository.getById(1L));
        createOrder(order);
        return pizzaOrderDto;
    }
}

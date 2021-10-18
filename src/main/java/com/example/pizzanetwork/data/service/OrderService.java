package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.dto.OrderDto;
import com.example.pizzanetwork.data.dto.PizzaOrderDto;
import com.example.pizzanetwork.data.entity.Order;
import com.example.pizzanetwork.data.entity.PizzaOrder;
import com.example.pizzanetwork.data.exception.Http400BadRequest;
import com.example.pizzanetwork.data.repository.OrderRepository;
import com.example.pizzanetwork.data.repository.PizzaOrderRepository;
import com.example.pizzanetwork.data.repository.PizzaRepository;
import com.example.pizzanetwork.data.repository.RestaurantRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    private final String ERROR_TEXT_ORDER_ID = "not found order in Order table";
    private final String ERROR_TEXT_PIZZA_ID = "not found pizza in Pizza table";
    Logger logger = Logger.getLogger(OrderService.class);

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
        return new PizzaOrderDto(pizzaOrder.getId(), pizzaOrder.getOrder_id().getId(),
                pizzaOrder.getPizza_id().getName(), pizzaOrder.getPizza_id().getId());
    }

    @Cacheable("order")
    public List<OrderDto> findAll() {
        logger.info("find all orders and cache result");
        final var result = orderRepository.findAll();
        return result.stream().map(this::createOrderDto).collect(Collectors.toList());
    }

    @Cacheable("pizzaOrderByName")
    public List<PizzaOrderDto> findAllPizzasByOrderId(Integer id) {
        logger.info("find all pizza orders and cache result");
        final var result = pizzaOrderRepository.getAllByOrderId((long) id);
        return result.stream().map(this::createPizzaOrderDto).collect(Collectors.toList());
    }
    @ExceptionHandler(Http400BadRequest.class)
    public List<PizzaOrderDto> createPizzaOrders(List<PizzaOrderDto> pizzaOrderDto) {
        logger.info("create pizza orders");
        var order = new Order();
        final BigDecimal[] price = {new BigDecimal(0)};
        Random random = new Random();
        order.setDate(new Date());
        pizzaOrderDto.forEach(it ->
        {
            price[0] = price[0].add(pizzaRepository.getById(it.getPizza_id()).getPrice());
            var pizzaOrder = new PizzaOrder();
            pizzaOrder.setOrder_id(orderRepository.findById(it.getOrder_id())
                    .orElseThrow(() -> new Http400BadRequest(ERROR_TEXT_ORDER_ID)));
            pizzaOrder.setPizza_id(pizzaRepository.findById(it.getPizza_id())
                    .orElseThrow(() -> new Http400BadRequest(ERROR_TEXT_PIZZA_ID)));
            pizzaOrderRepository.save(pizzaOrder);
        });
        order.setPrice(price[0]);
        order.setRestaurant_id(restaurantRepository
                .getById((long) random.nextInt((int) restaurantRepository.count()) + 1));
        createOrder(order);
        return pizzaOrderDto;
    }
}

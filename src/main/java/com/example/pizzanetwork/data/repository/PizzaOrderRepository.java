package com.example.pizzanetwork.data.repository;

import com.example.pizzanetwork.data.entity.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Long> {
    @Query(value = "SELECT * FROM pizza_order po where po.order_id = ?1"
            , nativeQuery = true)
    List<PizzaOrder> getAllByOrderId(Long id);

}

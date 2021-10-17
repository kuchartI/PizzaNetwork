package com.example.pizzanetwork.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaOrderDto {
    private Long id;

    private Long order_id;

    private String pizza_id;
}

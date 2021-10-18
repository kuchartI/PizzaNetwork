package com.example.pizzanetwork.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaOrderDto {
    private Long id;

    private Long order_id;

    @NotNull
    private String pizza_name;

    private Long pizza_id;


}

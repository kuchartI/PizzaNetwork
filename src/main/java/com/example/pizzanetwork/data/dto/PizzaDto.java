package com.example.pizzanetwork.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDto {

    private Long id;

    private String name;

    private String description;

    private int weight;

    private int size;

    private long category_id;

    @Digits(integer = 3, fraction = 2)
    private BigDecimal price;
}

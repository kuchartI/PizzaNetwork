package com.example.pizzanetwork.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private int weight;

    @NotNull
    private int size;

    @NotNull
    private long category_id;

    @Digits(integer = 3, fraction = 2)
    private BigDecimal price;
}

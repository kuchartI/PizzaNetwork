package com.example.pizzanetwork.data.dto;

import com.example.pizzanetwork.data.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;

    private Long restaurant_id;

    private BigDecimal price;

    private Date time_date;
}

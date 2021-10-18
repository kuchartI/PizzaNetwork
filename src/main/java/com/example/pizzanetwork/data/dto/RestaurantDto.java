package com.example.pizzanetwork.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {
    private Long id;

    private String address;

    private Time start_of_work;

    private Time end_of_work;

    private String phone;
}

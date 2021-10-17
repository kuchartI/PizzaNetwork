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

    @NotNull
    private String address;

    @NotNull
    private Time start_of_work;

    @NotNull
    private Time end_of_work;

    @NotNull
    private String phone;
}

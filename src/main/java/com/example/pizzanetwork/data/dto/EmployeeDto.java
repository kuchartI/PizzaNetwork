package com.example.pizzanetwork.data.dto;

import com.example.pizzanetwork.data.entity.Position;
import com.example.pizzanetwork.data.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    private String employee_name;

    private String employee_surname;

    private Restaurant restaurant_id;

    private String phone;

    private String schedule;

    private Position position_id;
}

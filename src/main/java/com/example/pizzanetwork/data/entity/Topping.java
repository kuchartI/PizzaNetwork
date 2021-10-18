package com.example.pizzanetwork.data.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "topping")
@Getter
@Setter
@ToString
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "topping_name")
    private String topping_name;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

}

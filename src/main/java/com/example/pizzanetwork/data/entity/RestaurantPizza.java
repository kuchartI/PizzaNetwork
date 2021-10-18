package com.example.pizzanetwork.data.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_pizza")
@Getter
@Setter

public class RestaurantPizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant_id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "pizza_id")
    private Pizza pizza_id;

    @NotNull
    @Column(name = "available")
    private boolean available;

}

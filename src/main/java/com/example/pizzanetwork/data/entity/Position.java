package com.example.pizzanetwork.data.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "position")
@Getter
@Setter
@ToString
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "position_name")
    private String position_name;

    @NotNull
    @Column(name = "salary")
    private int salary;

    @NotNull
    @Column(name = "amount_of_premium")
    private int amount_of_premium;

}

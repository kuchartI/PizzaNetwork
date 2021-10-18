package com.example.pizzanetwork.data.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String employee_name;

    @NotNull
    @Column(name = "employee_surname")
    private String employee_surname;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant_id;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "schedule")
    private String schedule;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "position_id")
    private Position position_id;

}

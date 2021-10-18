package com.example.pizzanetwork.data.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@ToString
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "start_of_work")
    private Time start_of_work;

    @NotNull
    @Column(name = "end_of_work")
    private Time end_of_work;

    @NotNull
    @Column(name = "phone")
    private String phone;

}

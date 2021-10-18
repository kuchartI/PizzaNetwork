package com.example.pizzanetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PizzaNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaNetworkApplication.class, args);
    }

}

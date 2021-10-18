package com.example.pizzanetwork.data.exception;

public abstract class AbstractException extends RuntimeException {

    AbstractException(String msg) {
        super(msg);
    }
}
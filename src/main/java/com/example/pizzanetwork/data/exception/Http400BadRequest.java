package com.example.pizzanetwork.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Http400BadRequest extends AbstractException {

    public Http400BadRequest(String msg) {
        super(msg);
    }

}

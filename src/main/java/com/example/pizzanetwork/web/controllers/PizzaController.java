package com.example.pizzanetwork.web.controllers;

import com.example.pizzanetwork.data.dto.PizzaDto;
import com.example.pizzanetwork.data.service.PizzaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pizza")
@Api("Pizza api")
public class PizzaController {
    private final PizzaService pizzaService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    @ApiOperation("Get pizzas")
    public List<PizzaDto> findAll() {
        return pizzaService.findAll();
    }

    @GetMapping("name/{name}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    @ApiOperation("Get pizzas by name")
    public List<PizzaDto> findAllByName(@PathVariable String name) {
        return pizzaService.findAllPizzaByName(name);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    @ApiOperation("Create pizza")
    public PizzaDto createPizza(@RequestBody @Valid PizzaDto pizzaDto) {
        return pizzaService.createPizza(pizzaDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ApiOperation("Delete pizza")
    public PizzaDto deletePizza(@PathVariable Integer id) {
        return pizzaService.deleteById(id);
    }

}

package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.dto.PizzaDto;
import com.example.pizzanetwork.data.entity.Pizza;
import com.example.pizzanetwork.data.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final CategoryService categoryService;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, CategoryService categoryService) {
        this.pizzaRepository = pizzaRepository;
        this.categoryService = categoryService;
    }

    public int count() {
        return (int) pizzaRepository.count();
    }

    public Pizza findById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public PizzaDto createPizza(PizzaDto pizzaDto) {
        var pizza = new Pizza();
        pizza.setName(pizzaDto.getName());
        pizza.setDescription(pizzaDto.getDescription());
        pizza.setPrice(pizzaDto.getPrice());
        pizza.setSize(pizzaDto.getSize());
        pizza.setWeight(pizzaDto.getWeight());
        pizza.setCategory_id(categoryService.findById(pizzaDto.getCategory_id()));
        return createPizzaDto(pizzaRepository.save(pizza));
    }

    private PizzaDto createPizzaDto(Pizza pizza) {
        return new PizzaDto(pizza.getId(), pizza.getName(), pizza.getDescription()
                , pizza.getWeight(), pizza.getSize(), pizza.getCategory_id().getId(), pizza.getPrice());
    }

    public void delete(Pizza pizza) {
        pizzaRepository.delete(pizza);
    }

    public PizzaDto deleteById(Integer id) {
        var pizza = pizzaRepository.getById((long) id);
        pizzaRepository.delete(pizzaRepository.getById((long) id));
        return createPizzaDto(pizza);
    }

    public List<PizzaDto> findAllPizzaByName(String name) {
        final var result = pizzaRepository.findAllByNameContaining(name);
        return result.stream().map(this::createPizzaDto).collect(Collectors.toList());
    }

    public List<PizzaDto> findAll() {
        final var result = pizzaRepository.findAll();
        return result.stream().map(this::createPizzaDto).collect(Collectors.toList());
    }
}

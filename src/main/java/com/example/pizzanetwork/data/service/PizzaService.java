package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.dto.PizzaDto;
import com.example.pizzanetwork.data.entity.Pizza;
import com.example.pizzanetwork.data.exception.Http400BadRequest;
import com.example.pizzanetwork.data.repository.CategoryRepository;
import com.example.pizzanetwork.data.repository.PizzaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PizzaService {
    private final String ERROR_TEXT = "not found category in Category table";

    Logger logger = Logger.getLogger(PizzaService.class);

    private final PizzaRepository pizzaRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, CategoryRepository categoryRepository) {
        this.pizzaRepository = pizzaRepository;
        this.categoryRepository = categoryRepository;
    }

    public int count() {
        return (int) pizzaRepository.count();
    }

    public Pizza findById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    @ExceptionHandler(Http400BadRequest.class)
    public PizzaDto createPizza(PizzaDto pizzaDto) {
        var pizza = new Pizza();
        pizza.setName(pizzaDto.getName());
        pizza.setDescription(pizzaDto.getDescription());
        pizza.setPrice(pizzaDto.getPrice());
        pizza.setSize(pizzaDto.getSize());
        pizza.setWeight(pizzaDto.getWeight());
        pizza.setCategory_id(categoryRepository.findById(pizzaDto.getCategory_id())
                .orElseThrow(() -> new Http400BadRequest(ERROR_TEXT)));
        return createPizzaDto(pizzaRepository.save(pizza));
    }

    private PizzaDto createPizzaDto(Pizza pizza) {
        return new PizzaDto(pizza.getId(), pizza.getName(), pizza.getDescription()
                , pizza.getWeight(), pizza.getSize(), pizza.getCategory_id().getId(), pizza.getPrice());
    }

    public void delete(Pizza pizza) {
        pizzaRepository.delete(pizza);
    }

    @CacheEvict("deletePizza")
    public PizzaDto deleteById(Integer id) {
        logger.info("delete pizza and refresh cache");
        var pizza = pizzaRepository.getById((long) id);
        pizzaRepository.delete(pizzaRepository.getById((long) id));
        return createPizzaDto(pizza);
    }

    @Cacheable("pizzaByName")
    public List<PizzaDto> findAllPizzaByName(String name) {
        logger.info("find pizza by matcher and cache");
        final var result = pizzaRepository.findAllByNameContaining(name);
        return result.stream().map(this::createPizzaDto).collect(Collectors.toList());
    }

    @Cacheable("pizzas")
    public List<PizzaDto> findAll() {
        logger.info("find all pizza and cache");
        final var result = pizzaRepository.findAll();
        return result.stream().map(this::createPizzaDto).collect(Collectors.toList());
    }
}

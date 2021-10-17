package com.example.pizzanetwork.data.service;

import com.example.pizzanetwork.data.entity.Category;
import com.example.pizzanetwork.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService( CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public int count() {
        return (int) categoryRepository.count();
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}

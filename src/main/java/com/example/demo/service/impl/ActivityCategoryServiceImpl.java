package com.example.demo.service.impl;

import com.example.demo.model.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.stereotype.Service;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository repository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {

        repository.findByCategoryName(category.getCategoryName())
                .ifPresent(c -> {
                    throw new RuntimeException("Category name already exists");
                });

        return repository.save(category);
    }

    @Override
    public ActivityCategory getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ActivityCategory not found"));
    }

    @Override
    public ActivityCategory getByName(String categoryName) {
        return repository.findByCategoryName(categoryName)
                .orElseThrow(() -> new RuntimeException("ActivityCategory not found"));
    }
}

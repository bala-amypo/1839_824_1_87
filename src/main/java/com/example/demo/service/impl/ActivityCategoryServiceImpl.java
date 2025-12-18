package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import com.example.demo.service.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository categoryRepository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // =================================
    // Create category (unique name check)
    // =================================
    @Override
    public ActivityCategory createCategory(ActivityCategory category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new IllegalArgumentException(
                    "Activity category already exists with name: " + category.getName()
            );
        }
        return categoryRepository.save(category);
    }

    // =================================
    // Get category by ID
    // =================================
    @Override
    public ActivityCategory getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Activity category not found with id: " + id
                        )
                );
    }

    // =================================
    // Get all categories
    // =================================
    @Override
    public List<ActivityCategory> getAllCategories() {
        return categoryRepository.findAll();
    }
}

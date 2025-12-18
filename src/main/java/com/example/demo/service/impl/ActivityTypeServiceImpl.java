package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import com.example.demo.service.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository typeRepository;
    private final ActivityCategoryRepository categoryRepository;

    public ActivityTypeServiceImpl(
            ActivityTypeRepository typeRepository,
            ActivityCategoryRepository categoryRepository) {

        this.typeRepository = typeRepository;
        this.categoryRepository = categoryRepository;
    }

    // ====================================
    // Create activity type under category
    // ====================================
    @Override
    public ActivityType createType(Long categoryId, ActivityType type) {

        ActivityCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Activity category not found with id: " + categoryId
                        )
                );

        type.setCategory(category);
        return typeRepository.save(type);
    }

    // ====================================
    // Get activity type by ID
    // ====================================
    @Override
    public ActivityType getType(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Activity type not found with id: " + id
                        )
                );
    }

    // ====================================
    // Get all types by category
    // ====================================
    @Override
    public List<ActivityType> getTypesByCategory(Long categoryId) {

        if (!categoryRepository.existsById(categoryId)) {
            throw new ResourceNotFoundException(
                    "Activity category not found with id: " + categoryId
            );
        }

        return typeRepository.findByCategoryId(categoryId);
    }
}

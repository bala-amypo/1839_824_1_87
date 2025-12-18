package com.example.demo.service.impl;

import com.example.demo.model.ActivityType;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository repository;

    public ActivityTypeServiceImpl(ActivityTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityType create(ActivityType activityType) {

        if (activityType.getUnit() == null || activityType.getUnit().isBlank()) {
            throw new RuntimeException("Unit must be provided");
        }

        if (activityType.getCategory() == null) {
            throw new RuntimeException("Category is required");
        }

        repository.findByTypeName(activityType.getTypeName())
                .ifPresent(a -> {
                    throw new RuntimeException("ActivityType name already exists");
                });

        return repository.save(activityType);
    }

    @Override
    public ActivityType getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ActivityType not found"));
    }

    @Override
    public ActivityType getByTypeName(String typeName) {
        return repository.findByTypeName(typeName)
                .orElseThrow(() -> new RuntimeException("ActivityType not found"));
    }
}

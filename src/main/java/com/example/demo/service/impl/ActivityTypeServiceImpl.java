package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.Category;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository activityTypeRepository;
    private final CategoryRepository categoryRepository;

    public ActivityTypeServiceImpl(ActivityTypeRepository activityTypeRepository,
                                   CategoryRepository categoryRepository) {
        this.activityTypeRepository = activityTypeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ActivityType create(ActivityType activityType) {

        if (activityTypeRepository.findByTypeName(activityType.getTypeName()).isPresent()) {
            throw new RuntimeException("Type name already exists");
        }

        Category category = categoryRepository.findById(
                activityType.getCategory().getId()
        ).orElseThrow(() -> new RuntimeException("Category not found"));

        activityType.setCategory(category);
        return activityTypeRepository.save(activityType);
    }

    @Override
    public List<ActivityType> getAll() {
        return activityTypeRepository.findAll();
    }

    @Override
    public ActivityType getById(Long id) {
        return activityTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ActivityType not found"));
    }

    @Override
    public void delete(Long id) {
        activityTypeRepository.deleteById(id);
    }
}

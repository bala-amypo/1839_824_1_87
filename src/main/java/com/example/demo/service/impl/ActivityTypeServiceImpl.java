package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.Category;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository activityTypeRepository;
    private final CategoryRepository categoryRepository;

    public ActivityTypeServiceImpl(ActivityTypeRepository activityTypeRepository,
                                   CategoryRepository categoryRepository) {
        this.activityTypeRepository = activityTypeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ActivityType createActivityType(String typeName, Long categoryId, String unit) {

        if (activityTypeRepository.existsByTypeName(typeName)) {
            throw new RuntimeException("Activity type name must be unique");
        }

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        ActivityType activityType = new ActivityType(typeName, category, unit);
        return activityTypeRepository.save(activityType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActivityType> getAllActivityTypes() {
        return activityTypeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ActivityType getActivityTypeById(Long id) {
        return activityTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity type not found"));
    }

    @Override
    public void deleteActivityType(Long id) {
        if (!activityTypeRepository.existsById(id)) {
            throw new RuntimeException("Activity type not found");
        }
        activityTypeRepository.deleteById(id);
    }
}

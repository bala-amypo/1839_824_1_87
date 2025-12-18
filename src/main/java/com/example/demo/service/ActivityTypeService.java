package com.example.demo.service;

import com.example.demo.entity.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    ActivityType createActivityType(String typeName, Long categoryId, String unit);

    List<ActivityType> getAllActivityTypes();

    ActivityType getActivityTypeById(Long id);

    void deleteActivityType(Long id);
}

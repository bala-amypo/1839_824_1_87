package com.example.demo.service;

import com.example.demo.entity.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    /**
     * Create a new activity type under a specific category.
     * @param categoryId ID of the category
     * @param type ActivityType object to create
     * @return created ActivityType
     */
    ActivityType createType(Long categoryId, ActivityType type);

    /**
     * Get a single activity type by its ID.
     * @param id ActivityType ID
     * @return found ActivityType
     */
    ActivityType getType(Long id);

    /**
     * Get all activity types under a specific category.
     * @param categoryId ID of the category
     * @return list of ActivityType
     */
    List<ActivityType> getTypesByCategory(Long categoryId);
}

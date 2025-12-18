package com.example.demo.service;

import com.example.demo.model.ActivityCategory;

public interface ActivityCategoryService {

    ActivityCategory createCategory(ActivityCategory category);

    ActivityCategory getById(Long id);

    ActivityCategory getByName(String categoryName);
}

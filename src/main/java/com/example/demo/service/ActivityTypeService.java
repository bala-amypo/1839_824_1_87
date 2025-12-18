package com.example.demo.service;

import com.example.demo.model.ActivityType;

public interface ActivityTypeService {

    ActivityType create(ActivityType activityType);

    ActivityType getById(Long id);

    ActivityType getByTypeName(String typeName);
}

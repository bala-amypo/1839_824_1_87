package com.example.demo.service;

import com.example.demo.model.ActivityType;

import java.util.List;

public interface ActivityTypeService {

    ActivityType create(ActivityType activityType);

    List<ActivityType> getAll();

    ActivityType getById(Long id);

    void delete(Long id);
}

package com.example.demo.service;

import com.example.demo.entity.ActivityType;
import java.util.List;

public interface ActivityTypeService {
    ActivityType create(ActivityType activityType);
    List<ActivityType> getAll();
    ActivityType getById(Long id);
    void delete(Long id);
}

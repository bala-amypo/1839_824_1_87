package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-types")
public class ActivityTypeController {

    private final ActivityTypeService service;

    public ActivityTypeController(ActivityTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityType create(@RequestBody ActivityType activityType) {
        return service.create(activityType);
    }

    @GetMapping
    public List<ActivityType> getAll() {
        return service.getAll();
    }
}

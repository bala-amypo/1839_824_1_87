package com.example.demo.controller;

import com.example.demo.model.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ActivityType getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/name/{typeName}")
    public ActivityType getByName(@PathVariable String typeName) {
        return service.getByTypeName(typeName);
    }
}

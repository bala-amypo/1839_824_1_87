package com.example.demo.controller;

import com.example.demo.model.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-types")
public class ActivityTypeController {

    private final ActivityTypeService activityTypeService;

    public ActivityTypeController(ActivityTypeService activityTypeService) {
        this.activityTypeService = activityTypeService;
    }

    @PostMapping
    public ActivityType create(@RequestBody ActivityType activityType) {
        return activityTypeService.create(activityType);
    }

    @GetMapping
    public List<ActivityType> getAll() {
        return activityTypeService.getAll();
    }

    @GetMapping("/{id}")
    public ActivityType getById(@PathVariable Long id) {
        return activityTypeService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        activityTypeService.delete(id);
    }
}

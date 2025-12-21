package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-types")
public class ActivityTypeController {

    private final ActivityTypeService activityTypeService;

    public ActivityTypeController(ActivityTypeService activityTypeService) {
        this.activityTypeService = activityTypeService;
    }

    // Create a new activity type under a category
    @PostMapping("/{categoryId}")
    public ResponseEntity<ActivityType> createType(
            @PathVariable Long categoryId,
            @RequestBody ActivityType type) {
        ActivityType savedType = activityTypeService.createType(categoryId, type);
        return ResponseEntity.ok(savedType);
    }

    // Get a single activity type
    @GetMapping("/{id}")
    public ResponseEntity<ActivityType> getType(@PathVariable Long id) {
        ActivityType type = activityTypeService.getType(id);
        return ResponseEntity.ok(type);
    }

    // Get all activity types under a category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getTypesByCategory(@PathVariable Long categoryId) {
        List<ActivityType> types = activityTypeService.getTypesByCategory(categoryId);
        return ResponseEntity.ok(types);
    }
}

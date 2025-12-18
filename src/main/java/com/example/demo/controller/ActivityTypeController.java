package com.example.demo.controller;

import com.example.demo.model.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.http.HttpStatus;
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

    /**
     * Create a new ActivityType under a category
     */
    @PostMapping("/category/{categoryId}")
    public ResponseEntity<ActivityType> createType(
            @PathVariable Long categoryId,
            @RequestBody ActivityType activityType) {

        ActivityType createdType =
                activityTypeService.createType(categoryId, activityType);

        return new ResponseEntity<>(createdType, HttpStatus.CREATED);
    }

    /**
     * Get ActivityType by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ActivityType> getType(@PathVariable Long id) {
        ActivityType activityType = activityTypeService.getType(id);
        return ResponseEntity.ok(activityType);
    }

    /**
     * Get all ActivityTypes by Category ID
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getTypesByCategory(
            @PathVariable Long categoryId) {

        List<ActivityType> types =
                activityTypeService.getTypesByCategory(categoryId);

        return ResponseEntity.ok(types);
    }
}

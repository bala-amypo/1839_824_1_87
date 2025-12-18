package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/{categoryId}/types")
public class ActivityTypeController {

    private final ActivityTypeService activityTypeService;

    public ActivityTypeController(ActivityTypeService activityTypeService) {
        this.activityTypeService = activityTypeService;
    }

    @PostMapping
    public ResponseEntity<ActivityType> createType(
            @PathVariable Long categoryId,
            @RequestBody ActivityType type
    ) {
        ActivityType createdType = activityTypeService.createType(categoryId, type);
        return new ResponseEntity<>(createdType, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ActivityType>> getTypesByCategory(@PathVariable Long categoryId) {
        List<ActivityType> types = activityTypeService.getTypesByCategory(categoryId);
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @GetMapping("/{typeId}")
    public ResponseEntity<ActivityType> getType(@PathVariable Long typeId) {
        ActivityType type = activityTypeService.getType(typeId);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }
}

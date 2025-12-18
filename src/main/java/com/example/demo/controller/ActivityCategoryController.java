package com.example.demo.controller;

import com.example.demo.model.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activity-categories")
public class ActivityCategoryController {

    private final ActivityCategoryService service;

    public ActivityCategoryController(ActivityCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityCategory create(@RequestBody ActivityCategory category) {
        return service.createCategory(category);
    }

    @GetMapping("/{id}")
    public ActivityCategory getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/name/{categoryName}")
    public ActivityCategory getByName(@PathVariable String categoryName) {
        return service.getByName(categoryName);
    }
}

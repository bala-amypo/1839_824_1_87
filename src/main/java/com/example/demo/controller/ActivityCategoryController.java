package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-categories")
public class ActivityCategoryController {

    private final ActivityCategoryService categoryService;

    public ActivityCategoryController(ActivityCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // =========================
    // Create category
    // =========================
    @PostMapping
    public ResponseEntity<ActivityCategory> createCategory(
            @RequestBody ActivityCategory category) {

        ActivityCategory savedCategory =
                categoryService.createCategory(category);

        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    // =========================
    // Get category by ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<ActivityCategory> getCategoryById(
            @PathVariable Long id) {

        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    // =========================
    // Get all categories
    // =========================
    @GetMapping
    public ResponseEntity<List<ActivityCategory>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}

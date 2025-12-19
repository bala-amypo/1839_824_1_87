package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService typeService;

    public ActivityTypeController(ActivityTypeService typeService) {
        this.typeService = typeService;
    }

    // POST /api/types/category/{categoryId}
    // create type under a category
    @PostMapping("/category/{categoryId}")
    public ResponseEntity<ActivityType> createType(
            @PathVariable Long categoryId,
            @RequestBody ActivityType type) {

        ActivityType savedType =
                typeService.createType(categoryId, type);

        return new ResponseEntity<>(savedType, HttpStatus.CREATED);
    }

    // GET /api/types/category/{categoryId}
    // list types by category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getTypesByCategory(
            @PathVariable Long categoryId) {

        return ResponseEntity.ok(
                typeService.getTypesByCategory(categoryId)
        );
    }

    // GET /api/types/{id}
    // get type by id
    @GetMapping("/{id}")
    public ResponseEntity<ActivityType> getTypeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                typeService.getType(id)
        );
    }
}

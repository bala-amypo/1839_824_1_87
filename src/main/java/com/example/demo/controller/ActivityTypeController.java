package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/activity-types")
public class ActivityTypeController {

    private final ActivityTypeService activityTypeService;

    public ActivityTypeController(ActivityTypeService activityTypeService) {
        this.activityTypeService = activityTypeService;
    }

    /* ==========================
       Create Activity Type
       ========================== */
    @PostMapping
    public ResponseEntity<ActivityType> create(@RequestBody Map<String, Object> request) {

        String typeName = (String) request.get("typeName");
        String unit = (String) request.get("unit");
        Long categoryId = Long.valueOf(request.get("categoryId").toString());

        ActivityType created = activityTypeService
                .createActivityType(typeName, categoryId, unit);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /* ==========================
       Get All Activity Types
       ========================== */
    @GetMapping
    public List<ActivityType> getAll() {
        return activityTypeService.getAllActivityTypes();
    }

    /* ==========================
       Get Activity Type By ID
       ========================== */
    @GetMapping("/{id}")
    public ActivityType getById(@PathVariable Long id) {
        return activityTypeService.getActivityTypeById(id);
    }

    /* ==========================
       Delete Activity Type
       ========================== */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        activityTypeService.deleteActivityType(id);
    }
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService service;

    public EmissionFactorController(EmissionFactorService service) {
        this.service = service;
    }

    // ✅ CREATE
    // POST /api/factors/type/{activityType}
    @PostMapping("/type/{activityType}")
    public EmissionFactor createFactor(
            @PathVariable String activityType,
            @RequestBody EmissionFactor factor) {

        return service.createFactor(activityType, factor);
    }

    // ✅ GET BY ID
    // GET /api/factors/{id}
    @GetMapping("/{id}")
    public EmissionFactor getFactorById(@PathVariable Long id) {
        return service.getFactorById(id);
    }

    // ✅ GET BY TYPE
    // GET /api/factors/type/{activityType}
    @GetMapping("/type/{activityType}")
    public List<EmissionFactor> getByType(@PathVariable String activityType) {
        return service.getByActivityType(activityType);
    }

    // ✅ GET ALL
    // GET /api/factors
    @GetMapping
    public List<EmissionFactor> getAll() {
        return service.getAllFactors();
    }
}

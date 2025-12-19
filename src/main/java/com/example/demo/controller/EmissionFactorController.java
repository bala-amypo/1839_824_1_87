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

    // POST /api/factors/{activityTypeId}
    @PostMapping("/{activityTypeId}")
    public EmissionFactor createFactor(
            @PathVariable String activityTypeId,
            @RequestBody EmissionFactor factor) {

        return service.createFactor(activityTypeId, factor);
    }

    // GET /api/factors/{id}
    @GetMapping("/{id}")
    public EmissionFactor getFactor(@PathVariable Long id) {
        return service.getFactorById(id);
    }

    // GET /api/factors/type/{activityType}
    @GetMapping("/type/{activityType}")
    public List<EmissionFactor> getByType(@PathVariable String activityType) {
        return service.getFactorByType(activityType);
    }

    // GET /api/factors
    @GetMapping
    public List<EmissionFactor> getAll() {
        return service.getAllFactors();
    }
}

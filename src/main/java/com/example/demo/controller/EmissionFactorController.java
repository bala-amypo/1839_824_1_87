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

    @PostMapping("/type/{activityType}")
    public EmissionFactor createFactor(
            @PathVariable String activityType,
            @RequestBody EmissionFactor factor) {

        return service.createFactor(activityType, factor);
    }     
    @GetMapping("/{id}")
    public EmissionFactor getFactorById(@PathVariable Long id) {
        return service.getFactorById(id);
    }
    @GetMapping("/type/{activityType}")
    public List<EmissionFactor> getByType(@PathVariable String activityType) {
        return service.getByActivityType(activityType);
    }
    @GetMapping
    public List<EmissionFactor> getAll() {
        return service.getAllFactors();
    }
}

package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService emissionFactorService;

    public EmissionFactorController(EmissionFactorService emissionFactorService) {
        this.emissionFactorService = emissionFactorService;
    }

    @PostMapping("/{activityTypeId}")
    public ResponseEntity<EmissionFactor> create(
            @PathVariable Long activityTypeId,
            @RequestBody EmissionFactor factor) {

        return new ResponseEntity<>(
                emissionFactorService.createFactor(activityTypeId, factor),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public EmissionFactor getById(@PathVariable Long id) {
        return emissionFactorService.getFactorById(id);
    }

    @GetMapping("/type/{activityTypeId}")
    public EmissionFactor getByType(@PathVariable Long activityTypeId) {
        return emissionFactorService.getFactorByActivityType(activityTypeId);
    }

    @GetMapping
    public List<EmissionFactor> getAll() {
        return emissionFactorService.getAllFactors();
    }
}

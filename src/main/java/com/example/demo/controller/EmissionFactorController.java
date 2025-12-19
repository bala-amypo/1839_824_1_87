package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorRepository emissionFactorRepository;

    public EmissionFactorController(EmissionFactorRepository emissionFactorRepository) {
        this.emissionFactorRepository = emissionFactorRepository;
    }

    // --------------------------------------------------
    // POST /api/factors/{activityTypeId}
    // Create emission factor
    // --------------------------------------------------
    @PostMapping("/{activityTypeId}")
    public ResponseEntity<EmissionFactor> createFactor(
            @PathVariable Long activityTypeId,
            @RequestBody EmissionFactor factor) {

        // activityType must already be set OR handled in service layer
        EmissionFactor saved = emissionFactorRepository.save(factor);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // --------------------------------------------------
    // GET /api/factors/{id}
    // Get factor by id
    // --------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<EmissionFactor> getFactor(@PathVariable Long id) {
        return emissionFactorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // --------------------------------------------------
    // GET /api/factors/type/{activityTypeId}
    // Get factor by activity type
    // --------------------------------------------------
    @GetMapping("/type/{activityTypeId}")
    public ResponseEntity<EmissionFactor> getFactorByType(
            @PathVariable Long activityTypeId) {

        return emissionFactorRepository.findByActivityTypeId(activityTypeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // --------------------------------------------------
    // GET /api/factors
    // List all factors
    // --------------------------------------------------
    @GetMapping
    public List<EmissionFactor> getAllFactors() {
        return emissionFactorRepository.findAll();
    }
}

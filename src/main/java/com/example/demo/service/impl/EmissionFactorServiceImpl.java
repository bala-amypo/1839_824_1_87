package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository repository;

    public EmissionFactorServiceImpl(EmissionFactorRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmissionFactor createFactor(String activityType, EmissionFactor factor) {
        factor.setActivityType(activityType);
        return repository.save(factor);
    }

    @Override
    public EmissionFactor getFactorById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmissionFactor not found"));
    }

    @Override
    public List<EmissionFactor> getByActivityType(String activityType) {
        return repository.findByActivityType(activityType);
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return repository.findAll();
    }
}

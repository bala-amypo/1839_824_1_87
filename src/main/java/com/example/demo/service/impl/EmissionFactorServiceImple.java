package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository emissionFactorRepository;
    private final ActivityTypeRepository activityTypeRepository;

    public EmissionFactorServiceImpl(EmissionFactorRepository emissionFactorRepository,
                                     ActivityTypeRepository activityTypeRepository) {
        this.emissionFactorRepository = emissionFactorRepository;
        this.activityTypeRepository = activityTypeRepository;
    }

    @Override
    public EmissionFactor createFactor(Long activityTypeId, EmissionFactor factor) {

        ActivityType activityType = activityTypeRepository.findById(activityTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Activity type not found"));

        // Enforce one factor per activity type
        emissionFactorRepository.findByActivityTypeId(activityTypeId)
                .ifPresent(f -> {
                    throw new IllegalStateException("Emission factor already exists for this activity type");
                });

        factor.setActivityType(activityType);
        return emissionFactorRepository.save(factor);
    }

    @Override
    public EmissionFactor getFactorById(Long id) {
        return emissionFactorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Emission factor not found"));
    }

    @Override
    public EmissionFactor getFactorByActivityType(Long activityTypeId) {
        return emissionFactorRepository.findByActivityTypeId(activityTypeId)
                .orElseThrow(() -> new IllegalArgumentException("Emission factor not found for activity type"));
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return emissionFactorRepository.findAll();
    }
}

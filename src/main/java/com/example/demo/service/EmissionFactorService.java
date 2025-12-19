package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorService {

    EmissionFactor createFactor(String activityType, EmissionFactor factor);

    EmissionFactor getFactorById(Long id);

    List<EmissionFactor> getByActivityType(String activityType);

    List<EmissionFactor> getAllFactors();
}

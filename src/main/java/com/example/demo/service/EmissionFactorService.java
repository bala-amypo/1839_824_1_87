package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;

import java.util.List;

public interface EmissionFactorService {

    EmissionFactor createFactor(Long activityTypeId, EmissionFactor factor);

    EmissionFactor getFactorById(Long id);

    EmissionFactor getFactorByActivityType(Long activityTypeId);

    List<EmissionFactor> getAllFactors();
}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorRepository
        extends JpaRepository<EmissionFactor, Long> {

    List<EmissionFactor> findByActivityType(String activityType);
}

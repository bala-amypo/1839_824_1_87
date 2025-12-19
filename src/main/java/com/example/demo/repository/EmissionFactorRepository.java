package com.example.demo.repository;

import com.example.demo.entity.EmissionFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmissionFactorRepository
        extends JpaRepository<EmissionFactor, Long> {

    // Optional custom method
    // Optional<EmissionFactor> findByActivityTypeId(Long activityTypeId);

}

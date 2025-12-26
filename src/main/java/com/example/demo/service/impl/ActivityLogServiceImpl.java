package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl {

    private final ActivityLogRepository logRepo;
    private final UserRepository userRepo;
    private final ActivityTypeRepository typeRepo;
    private final EmissionFactorRepository factorRepo;

    public ActivityLogServiceImpl(ActivityLogRepository l, UserRepository u,
                                  ActivityTypeRepository t, EmissionFactorRepository f) {
        this.logRepo = l;
        this.userRepo = u;
        this.typeRepo = t;
        this.factorRepo = f;
    }

    public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {

        User u = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ActivityType t = typeRepo.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        if (log.getActivityDate().isAfter(LocalDate.now()))
            throw new ValidationException("cannot be in the future");

        EmissionFactor f = factorRepo.findByActivityType_Id(typeId)
                .orElseThrow(() -> new ValidationException("No emission factor configured"));

        log.setUser(u);
        log.setActivityType(t);
        log.setEstimatedEmission(log.getQuantity() * f.getFactorValue());

        return logRepo.save(log);
    }
}

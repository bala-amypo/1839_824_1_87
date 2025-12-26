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

    public ActivityLogServiceImpl(ActivityLogRepository logRepo,
                                  UserRepository userRepo,
                                  ActivityTypeRepository typeRepo,
                                  EmissionFactorRepository factorRepo) {
        this.logRepo = logRepo;
        this.userRepo = userRepo;
        this.typeRepo = typeRepo;
        this.factorRepo = factorRepo;
    }

    public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        ActivityType type = typeRepo.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        if (log.getActivityDate().isAfter(LocalDate.now()))
            throw new ValidationException("cannot be in the future");

        EmissionFactor factor = factorRepo.findByActivityType_Id(typeId)
                .orElseThrow(() -> new ValidationException("No emission factor configured"));

        log.setUser(user);
        log.setActivityType(type);
        log.setEstimatedEmission(log.getQuantity() * factor.getFactorValue());

        return logRepo.save(log);
    }

    public List<ActivityLog> getLogsByUser(Long userId) {
        return logRepo.findByUser_Id(userId);
    }

    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate s, LocalDate e) {
        return logRepo.findByUser_IdAndActivityDateBetween(userId, s, e);
    }
}

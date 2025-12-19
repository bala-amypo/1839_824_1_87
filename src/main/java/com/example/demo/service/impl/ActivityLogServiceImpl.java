package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;
    private final EmissionFactorRepository emissionFactorRepository;

    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository,
                                  EmissionFactorRepository emissionFactorRepository) {
        this.activityLogRepository = activityLogRepository;
        this.emissionFactorRepository = emissionFactorRepository;
    }

    @Override
    public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {

        if (log.getActivityDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Future date not allowed");
        }

        EmissionFactor factor = emissionFactorRepository.findById(typeId)
                .orElseThrow(() -> new IllegalArgumentException("Emission factor not found"));

        log.setEstimatedEmission(log.getQuantity() * factor.getFactorValue());
        log.setUserId(userId);

        return activityLogRepository.save(log);
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return activityLogRepository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(Long userId,
                                                  LocalDate start,
                                                  LocalDate end) {
        return activityLogRepository
                .findByUserIdAndActivityDateBetween(userId, start, end);
    }

    @Override
    public ActivityLog getLog(Long id) {
        return activityLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Log not found"));
    }
}

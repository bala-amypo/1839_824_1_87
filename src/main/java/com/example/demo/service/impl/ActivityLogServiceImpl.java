package com.example.service.impl;

import com.example.entity.ActivityLog;
import com.example.entity.EmissionFactor;
import com.example.repository.ActivityLogRepository;
import com.example.repository.EmissionFactorRepository;
import com.example.service.ActivityLogService;
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

        // 1. Validate future date
        if (log.getActivityDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Activity date cannot be in the future");
        }

        // 2. Fetch EmissionFactor for the type
        EmissionFactor factor = emissionFactorRepository.findById(typeId)
                .orElseThrow(() -> new IllegalArgumentException("Emission factor not found"));

        // 3. Calculate estimated emission
        double estimatedEmission = log.getQuantity() * factor.getFactorValue();
        log.setEstimatedEmission(estimatedEmission);

        // 4. Set user
        log.setUserId(userId);

        return activityLogRepository.save(log);
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return activityLogRepository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end) {
        return activityLogRepository.findByUserIdAndActivityDateBetween(userId, start, end);
    }

    @Override
    public ActivityLog getLog(Long id) {
        return activityLogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Activity log not found"));
    }
}

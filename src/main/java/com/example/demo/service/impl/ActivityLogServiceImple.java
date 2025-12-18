package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository repository;

    public ActivityLogServiceImpl(ActivityLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityLog create(ActivityLog activityLog) {
        return repository.save(activityLog);
    }

    @Override
    public ActivityLog getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("ActivityLog not found with id: " + id));
    }

    @Override
    public List<ActivityLog> getByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> getByActivityType(Long activityTypeId) {
        return repository.findByActivityTypeId(activityTypeId);
    }

    @Override
    public List<ActivityLog> getByDateRange(LocalDate startDate, LocalDate endDate) {
        return repository.findByActivityDateBetween(startDate, endDate);
    }
}

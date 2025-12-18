package com.example.demo.service.impl;

import com.example.demo.model.ActivityLog;
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
    public ActivityLog save(ActivityLog activityLog) {
        return repository.save(activityLog);
    }

    @Override
    public List<ActivityLog> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> getByActivityTypeId(Long activityTypeId) {
        return repository.findByActivityTypeId(activityTypeId);
    }

    @Override
    public List<ActivityLog> getByDateRange(LocalDate startDate, LocalDate endDate) {
        return repository.findByActivityDateBetween(startDate, endDate);
    }
}

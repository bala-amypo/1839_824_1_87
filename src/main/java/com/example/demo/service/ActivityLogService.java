package com.example.demo.service;

import com.example.demo.model.ActivityLog;

import java.time.LocalDate;
import java.util.List;

public interface ActivityLogService {

    ActivityLog save(ActivityLog activityLog);

    List<ActivityLog> getByUserId(Long userId);

    List<ActivityLog> getByActivityTypeId(Long activityTypeId);

    List<ActivityLog> getByDateRange(LocalDate startDate, LocalDate endDate);
}

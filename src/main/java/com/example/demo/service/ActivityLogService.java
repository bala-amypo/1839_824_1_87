package com.example.service;

import com.example.entity.ActivityLog;

import java.time.LocalDate;
import java.util.List;

public interface ActivityLogService {

    ActivityLog logActivity(Long userId, Long typeId, ActivityLog log);

    List<ActivityLog> getLogsByUser(Long userId);

    List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end);

    ActivityLog getLog(Long id);
}

package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    // Create a new activity log
    @PostMapping("/{userId}/{typeId}")
    public ResponseEntity<ActivityLog> logActivity(
            @PathVariable Long userId,
            @PathVariable Long typeId,
            @RequestBody ActivityLog log) {

        // The service will handle estimatedEmission calculation
        ActivityLog savedLog = activityLogService.logActivity(userId, typeId, log);
        return ResponseEntity.ok(savedLog);
    }

    // Get all logs for a user
    @GetMapping("/{userId}")
    public ResponseEntity<List<ActivityLog>> getLogsByUser(@PathVariable Long userId) {
        List<ActivityLog> logs = activityLogService.getLogsByUser(userId);
        return ResponseEntity.ok(logs);
    }

    // Get logs for a user between dates
    @GetMapping("/{userId}/between")
    public ResponseEntity<List<ActivityLog>> getLogsByUserAndDate(
            @PathVariable Long userId,
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        List<ActivityLog> logs = activityLogService.getLogsByUserAndDate(userId, start, end);
        return ResponseEntity.ok(logs);
    }

    // Get a single log by id
    @GetMapping("/log/{id}")
    public ResponseEntity<ActivityLog> getLog(@PathVariable Long id) {
        ActivityLog log = activityLogService.getLog(id);
        return ResponseEntity.ok(log);
    }
}

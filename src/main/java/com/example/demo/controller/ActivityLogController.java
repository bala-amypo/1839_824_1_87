package com.example.demo.controller;

import com.example.demo.model.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    // ✅ Create new ActivityLog
    @PostMapping
    public ActivityLog createActivityLog(@RequestBody ActivityLog activityLog) {
        return activityLogService.saveActivityLog(activityLog);
    }

    // ✅ Get ActivityLog by ID
    @GetMapping("/{id}")
    public ActivityLog getActivityLogById(@PathVariable Long id) {
        return activityLogService.getActivityLogById(id);
    }

    // ✅ Get all ActivityLogs
    @GetMapping
    public List<ActivityLog> getAllActivityLogs() {
        return activityLogService.getAllActivityLogs();
    }

    // ✅ Get ActivityLogs by User ID
    @GetMapping("/user/{userId}")
    public List<ActivityLog> getActivityLogsByUser(@PathVariable Long userId) {
        return activityLogService.getActivityLogsByUserId(userId);
    }

    // ✅ Get ActivityLogs by ActivityType ID
    @GetMapping("/type/{typeId}")
    public List<ActivityLog> getActivityLogsByActivityType(@PathVariable Long typeId) {
        return activityLogService.getActivityLogsByActivityTypeId(typeId);
    }

    // ✅ Get ActivityLogs between dates
    @GetMapping("/date-range")
    public List<ActivityLog> getActivityLogsByDateRange(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        return activityLogService.getActivityLogsByDateRange(startDate, endDate);
    }

    // ✅ Delete ActivityLog
    @DeleteMapping("/{id}")
    public String deleteActivityLog(@PathVariable Long id) {
        activityLogService.deleteActivityLog(id);
        return "ActivityLog deleted successfully";
    }
}

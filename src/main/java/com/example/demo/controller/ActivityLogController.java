package com.example.demo.controller;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class ActivityLogController {

    private final ActivityLogService service;

    public ActivityLogController(ActivityLogService service) {
        this.service = service;
    }

    @PostMapping("/{userId}/{typeId}")
    public ActivityLog log(@PathVariable Long userId,
                           @PathVariable Long typeId,
                           @RequestBody ActivityLogRequest req) {

        ActivityLog log = new ActivityLog();
        log.setQuantity(req.getQuantity());
        log.setActivityDate(req.getActivityDate());

        return service.logActivity(userId, typeId, log);
    }

    @GetMapping("/user/{userId}")
    public List<ActivityLog> byUser(@PathVariable Long userId) {
        return service.getLogsByUser(userId);
    }

    @GetMapping("/user/{userId}/range")
    public List<ActivityLog> byDate(@PathVariable Long userId,
                                    @RequestParam LocalDate start,
                                    @RequestParam LocalDate end) {
        return service.getLogsByUserAndDate(userId, start, end);
    }
}

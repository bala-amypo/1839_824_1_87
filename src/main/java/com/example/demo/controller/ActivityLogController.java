package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.ActivityType;
import com.example.demo.entity.User;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    private final ActivityLogRepository activityLogRepository;
    private final ActivityTypeRepository activityTypeRepository;
    private final UserRepository userRepository;

    public ActivityLogController(ActivityLogRepository activityLogRepository,
                                 ActivityTypeRepository activityTypeRepository,
                                 UserRepository userRepository) {
        this.activityLogRepository = activityLogRepository;
        this.activityTypeRepository = activityTypeRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<?> createActivityLog(
            @RequestParam Long activityTypeId,
            @RequestParam Long userId,
            @RequestParam Double quantity,
            @RequestParam LocalDate activityDate) {

        if (quantity <= 0) {
            return ResponseEntity.badRequest().body("Quantity must be greater than 0");
        }

        if (activityDate.isAfter(LocalDate.now())) {
            return ResponseEntity.badRequest().body("Activity date cannot be in the future");
        }

        Optional<ActivityType> activityTypeOpt = activityTypeRepository.findById(activityTypeId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (activityTypeOpt.isEmpty() || userOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid activity type or user");
        }

        ActivityLog activityLog = new ActivityLog();
        activityLog.setActivityType(activityTypeOpt.get());
        activityLog.setUser(userOpt.get());
        activityLog.setQuantity(quantity);
        activityLog.setActivityDate(activityDate);

        ActivityLog savedLog = activityLogRepository.save(activityLog);

        return new ResponseEntity<>(savedLog, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ActivityLog> getAllActivityLogs() {
        return activityLogRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityLog> getActivityLogById(@PathVariable Long id) {
        return activityLogRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityLog(@PathVariable Long id) {
        if (!activityLogRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        activityLogRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.demo.repository;

import com.example.demo.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    List<ActivityLog> findByUserId(Long userId);

    List<ActivityLog> findByActivityTypeId(Long activityTypeId);

    List<ActivityLog> findByActivityDateBetween(LocalDate startDate, LocalDate endDate);
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

}
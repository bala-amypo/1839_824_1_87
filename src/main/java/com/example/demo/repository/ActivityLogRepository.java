package com.example.repository;

import com.example.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    // Custom query methods (optional examples)

    // Find logs by user ID
    // List<ActivityLog> findByUserId(Long userId);

    // Find logs by action type
    // List<ActivityLog> findByActionType(String actionType);

}

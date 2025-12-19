package com.example.demo.repository;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityTypeRepository
        extends JpaRepository<ActivityType, Long> {

    // ✅ THIS METHOD FIXES ERROR #2
    List<ActivityType> findByCategory(ActivityCategory category);
}

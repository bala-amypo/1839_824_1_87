package com.example.demo.repository;

import com.example.demo.entity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityTypeRepository
        extends JpaRepository<ActivityType, Long> {

    Optional<ActivityType> findByTypeName(String typeName);

    boolean existsByTypeName(String typeName);
}

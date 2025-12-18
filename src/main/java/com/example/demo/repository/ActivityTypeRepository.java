package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ActivityType;

public interface ActivityTypeRepository extends JpaRepository<ActivtyType, Long> {

}
package com.example.demo.repository;

import com.example.demo.model.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Long> {

    Optional<ActivityCategory> findByCategoryName(String categoryName);
}

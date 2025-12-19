package com.example.demo.repository;

import com.example.demo.entity.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityCategoryRepository
        extends JpaRepository<ActivityCategory, Long> {

    // Optional helper method (useful for uniqueness checks)
    Optional<ActivityCategory> findByCategoryName(String categoryName);

    boolean existsByCategoryName(String categoryName);
}

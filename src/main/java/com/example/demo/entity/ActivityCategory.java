package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ActivityCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String categoryName;
    private String description;
    private LocalDateTime createdAt;

    public ActivityCategory() {}

    public ActivityCategory(Long id, String name, String desc, LocalDateTime createdAt) {
        this.id = id;
        this.categoryName = name;
        this.description = desc;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getCategoryName() { return categoryName; }
}

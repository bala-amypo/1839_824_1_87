package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ActivityType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeName;

    @ManyToOne
    private ActivityCategory category;

    private String unit;
    private LocalDateTime createdAt;

    public ActivityType() {}

    public ActivityType(Long id, String name, ActivityCategory cat, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.typeName = name;
        this.category = cat;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public ActivityCategory getCategory() { return category; }
}

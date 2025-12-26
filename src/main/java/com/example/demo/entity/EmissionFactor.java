package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EmissionFactor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    private Double factorValue;
    private String unit;
    private LocalDateTime createdAt;

    public EmissionFactor() {}

    public EmissionFactor(Long id, ActivityType type, Double value, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.activityType = type;
        this.factorValue = value;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Double getFactorValue() { return factorValue; }
    public ActivityType getActivityType() { return activityType; }
}

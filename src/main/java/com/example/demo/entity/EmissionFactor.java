package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emission_factor")
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * One emission factor per activity type
     * You can switch to @OneToOne if activityType is unique
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType activityType;

    @Column(nullable = false)
    private Double factorValue;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // ---- Lifecycle hook ----
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ---- Validation ----
    @PrePersist
    @PreUpdate
    private void validate() {
        if (factorValue == null || factorValue <= 0) {
            throw new IllegalArgumentException("factorValue must be greater than 0");
        }
    }

    // ---- Constructors ----
    public EmissionFactor() {}

    // ---- Getters & Setters ----
    public Long getId() {
        return id;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Double getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(Double factorValue) {
        this.factorValue = factorValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

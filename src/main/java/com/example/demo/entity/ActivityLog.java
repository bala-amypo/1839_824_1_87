package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activity_log")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDate activityDate;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    private double estimatedEmission;

    // Optional: activity type reference
    @Column(nullable = false)
    private Long typeId;

    // ---- Constructors ----
    public ActivityLog() {
    }

    public ActivityLog(Long userId, LocalDate activityDate,
                       double quantity, double estimatedEmission, Long typeId) {
        this.userId = userId;
        this.activityDate = activityDate;
        this.quantity = quantity;
        this.estimatedEmission = estimatedEmission;
        this.typeId = typeId;
    }

    // ---- Getters & Setters ----
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getEstimatedEmission() {
        return estimatedEmission;
    }

    public void setEstimatedEmission(double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}

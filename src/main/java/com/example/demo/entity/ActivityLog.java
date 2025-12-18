package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many ActivityLogs belong to one ActivityType
    @ManyToOne(optional = false)
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType activityType;

    // Many ActivityLogs belong to one User
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Double quantity;

    @Column(nullable = false)
    private LocalDate activityDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime loggedAt;

    @Column(nullable = false)
    private Double estimatedEmission;

    // ---------- RULE ENFORCEMENT ----------
    @PrePersist
    protected void onCreate() {
        this.loggedAt = LocalDateTime.now();

        // activityDate cannot be future
        if (activityDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Activity date cannot be in the future");
        }

        // quantity must be > 0
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        // estimatedEmission = quantity * factorValue
        // assuming ActivityType has getFactorValue()
        this.estimatedEmission = quantity * activityType.getFactorValue();
    }

    // ---------- GETTERS & SETTERS ----------

    public Long getId() {
        return id;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public Double getEstimatedEmission() {
        return estimatedEmission;
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_log")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many logs → One activity type
    @ManyToOne
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType activityType;

    // Many logs → One user
    @ManyToOne
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

    // Auto-generate loggedAt
    @PrePersist
    protected void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }

    // ---------- Constructors ----------
    public ActivityLog() {
    }

    // ---------- Getters & Setters ----------
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
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.quantity = quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        if (activityDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Activity date cannot be in the future");
        }
        this.activityDate = activityDate;
    }

    public LocalDateTime getLoggedAt() {
        return loggedAt;
    }

    public Double getEstimatedEmission() {
        return estimatedEmission;
    }

    public void setEstimatedEmission(Double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }
}

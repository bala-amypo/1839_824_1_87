package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.*;

@Entity
public class ActivityLog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private Double quantity;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private Double estimatedEmission;

    public ActivityLog() {}

    public ActivityLog(Long id, ActivityType t, User u, Double q,
                       LocalDate d, LocalDateTime l, Double e) {
        this.id = id;
        this.activityType = t;
        this.user = u;
        this.quantity = q;
        this.activityDate = d;
        this.loggedAt = l;
        this.estimatedEmission = e;
    }

    @PrePersist
    public void prePersist() {
        loggedAt = LocalDateTime.now();
    }

    // getters & setters
    public void setQuantity(Double q) { this.quantity = q; }
    public Double getQuantity() { return quantity; }
    public void setActivityDate(LocalDate d) { this.activityDate = d; }
    public LocalDate getActivityDate() { return activityDate; }
    public void setEstimatedEmission(Double e) { this.estimatedEmission = e; }
    public Double getEstimatedEmission() { return estimatedEmission; }
    public void setUser(User u) { this.user = u; }
    public void setActivityType(ActivityType t) { this.activityType = t; }
}

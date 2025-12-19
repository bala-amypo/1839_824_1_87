package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_log")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "activity_type_id")
    private ActivityType activityType;

    private Double value;

    private LocalDateTime logTime;

    @PrePersist
    public void onCreate() {
        this.logTime = LocalDateTime.now();
    }

    // getters & setters
}

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @ManyToOne
    private User user;

    private Double quantity;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private Double estimatedEmission;

    @PrePersist
    public void prePersist() {
        loggedAt = LocalDateTime.now();
    }
}

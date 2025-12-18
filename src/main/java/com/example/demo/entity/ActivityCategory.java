package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "activity_categories",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
    }
)
public class ActivityCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // =====================
    // Constructors
    // =====================

    public ActivityCategory() {
    }

    public ActivityCategory(String name) {
        this.name = name;
    }

    // =====================
    // Getters & Setters
    // =====================

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

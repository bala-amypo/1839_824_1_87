package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "activity_type")
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String typeName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ActivityCategory category;

    public ActivityType() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public ActivityCategory getCategory() {
        return category;
    }

    // ✅ THIS METHOD FIXES ERROR #1
    public void setCategory(ActivityCategory category) {
        this.category = category;
    }
}

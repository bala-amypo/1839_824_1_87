package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public class ActivityCategory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String description;
    private LocalDateTime createdAt;

public long getId(){
    return id; 
}
public void setId(Long id){
    this.id=id;
}
public String getCategory(){
    return category;
}
public void setCategory(String category){
    this.category=category;
}
public String getDescription(){
    return description;
}
public void setDescription(String description){
    this.description=description;
}
public LocalDateTime getCreatedAt(){
    return createdAt;

}
public void setCreatedAt(LocalDateTime createdAt){
this.createdAt=createdAt;
}
public ActivityCategory(Long id,String category,String description,LocalDateTime createdAt){
    this.id=id;
    this.category=category;
    this.description=description;
    this.createdAt=createdAt;
}
public ActivityCategory(){}
}
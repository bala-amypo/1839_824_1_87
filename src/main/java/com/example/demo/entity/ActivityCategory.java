package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public class ActivityCategory
{
    private Long id;
    private String categoryName;
    private String description;
    private LocalDateTime createdAt;

public long getId(){
    return id; 
}
public void setId(Long id){
    this.id=id;
}
public String getCategoryName(){
    return categoryName;
}
public void setCategoryName(String categoryName){
    this.categoryName=categoryName;
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
public ActivityCategory(Long id,String categoryName,String description,LocalDateTime createdAt){
    this.id=id;
    this.categoryName=categoryName;
    this.description=description;
    this.createdAt=createdAt;
}
public ActivityCategory(){}
}
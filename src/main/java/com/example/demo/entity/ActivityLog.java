package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public class ActivityLog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double quantity;;
    private LocalDate acivityDate;
    private LocalDatetime loggedAt;
    private Double estimatedEmission;

public Long getId(){
    return id; 
}
public void setId(Long id){
    this.id=id;
}
public Double getIdQuantity(){
    return quantity;
}
public void setQuantity(Double quantity){
    this.quantity=quantity;
}
public (){
    return unit;
}
public void setUnit(String unit){
    this.unit=unit;
}
public LocalDateTime getCreatedAt(){
    return createdAt;

}
public void setCreatedAt(LocalDateTime createdAt){
this.createdAt=createdAt;
}
public ActivityLog(){}
public ActivityLog(Long id,String typeName,String unit,LocalDateTime createdAt){
    this.id=id;
    this.typeName=typeName;
    this.unit=unit;
    this.createdAt=createdAt;
}
}
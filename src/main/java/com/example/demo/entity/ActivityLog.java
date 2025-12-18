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
public LocalDate getIdActivityDate(){
    return activityDate;
}
public void setActivityDate(LocalDate activityDate){
    this.activityDate=activityDate;
}
public LocalDateTime getLoggedAt(){
    return loggedAt;

}
public void setLoggedAt(LocalDateTime loggedAt){
this.loggedAt=loggedAt;
}
public class Double 
public ActivityLog(){}
public ActivityLog(Long id,String typeName,String unit,LocalDateTime createdAt){
    this.id=id;
    this.typeName=typeName;
    this.unit=unit;
    this.createdAt=createdAt;
}
}
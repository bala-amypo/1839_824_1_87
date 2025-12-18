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
public class Double getEstimatedEmission(){
    return estimatedEmission;
}
public void setEstimatedEmission(Double estimatedEmission){
    this.estimatedEmission=estimatedEmission;
}
public ActivityLog(){}
public ActivityLog(Long id,Double quantity, LocalDate activityDate,LocalDateTime loggedAt,Double estimatedEmission){
    this.id=id;
    this.quantity=quantity;
    this.activityDate=activityDate;
    this.loggedAt=loggedAt;
    this.estimatedEmission=estimatedEmission;
}
}
package com.example.demo.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class EmissionFactor{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Double factorValue;
    private String unit;
    private LocalDateTime createdAt;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Double getFactorValue(){
        return factorValue;
    }
    public void setFactorValue(Double factorValue){
        this.factorValue=factorValue;
    }
    public String getUnit(){
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
public EmissionFactor()
{}
public EmissionFactor(Long id,Double factorValue,String unit,LocalDateTime createdAt){
    this.id=id;
    this.factorValue=factorValue;
    this.unit=unit;
    this.createdAt=createdAt;
}


}
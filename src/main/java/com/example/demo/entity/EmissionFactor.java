package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class User{
    @Id
    private Long id;
    private Double factorValue;
    private String unit;
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
    public void setUnit(String password){
        this.password=password;
    }
    public Role getRole(){
        return role;
    }
    public void setRole(Role role){
        this.role=role;
    }
            public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
public User()
{}
public User(Long id,String fullName,String email,String password,Role role,LocalDateTime createdAt){
    this.id=id;
    this.fullName=fullName;
    this.email=email;
    this.password=password;
    this.role=role;
    this.createdAt=createdAt;
}


}
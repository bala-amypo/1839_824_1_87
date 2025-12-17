package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.email;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
@Entity
public class User{
    @Id
    private Long id;
    private String fullName;
    @Column (unique=true)
    private String email;
    private String password;
    private Role role=Role.USER;
    public enum Role{
        ADMIN,
        USER
    }
    private LocalDateTime  createdAt;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
        public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
            public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
            public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
            public String getRole(){
        return role;
    }
    public void setRole(String roll){
        this.role=role;
    }
            public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }



}
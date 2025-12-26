package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository r, PasswordEncoder e) {
        this.repo = r;
        this.encoder = e;
    }

    public User registerUser(User u) {
        if (repo.existsByEmail(u.getEmail()))
            throw new ValidationException("Email already in use");

        if (u.getPassword().length() < 8)
            throw new ValidationException("Password must be at least 8 characters");

        u.setPassword(encoder.encode(u.getPassword()));
        if (u.getRole() == null) u.setRole("USER");
        return repo.save(u);
    }

    public User getUser(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}

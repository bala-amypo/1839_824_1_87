package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET_KEY = "verysecretkeyverysecretkey123";

    // Generate token with subject
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Generate token for User
    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        claims.put("userId", user.getId());

        return generateToken(claims, user.getEmail());
    }

    // Extract username (email)
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // Extract role
    public String extractRole(String token) {
        return (String) getClaims(token).get("role");
    }

    // Extract userId
    public Long extractUserId(String token) {
        return ((Number) getClaims(token).get("userId")).longValue();
    }

    // Validate token
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }

    // 🔑 REQUIRED BY TESTS
    public Jwt<?, ?> parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parse(token);
    }

    // Internal helper
    private Claims getClaims(String token) {
        Jwt<?, ?> jwt = parseToken(token);
        return (Claims) jwt.getBody();
    }
}

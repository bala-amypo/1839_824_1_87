package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String SECRET = "secretkeysecretkeysecretkey123456";

    public String generateToken(Map<String,Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .compact();
    }

    public String generateTokenForUser(User u) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId", u.getId());
        claims.put("email", u.getEmail());
        claims.put("role", u.getRole());
        return generateToken(claims, u.getEmail());
    }

    public String extractUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    public String extractRole(String token) {
        return (String) parseToken(token).getPayload().get("role");
    }

    public Long extractUserId(String token) {
        return ((Number) parseToken(token).getPayload().get("userId")).longValue();
    }

    public boolean isTokenValid(String token, String user) {
        return extractUsername(token).equals(user);
    }

    public Jwt<?,?> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parse(token);
    }
}

package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date())
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        claims.put("userId", user.getId());
        return generateToken(claims, user.getEmail());
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return (String) getClaims(token).get("role");
    }

    public Long extractUserId(String token) {
        return ((Number) getClaims(token).get("userId")).longValue();
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }

    // 🔥 FINAL FIX: explicit cast
    @SuppressWarnings("unchecked")
    public Jwt<?, Claims> parseToken(String token) {
        return (Jwt<?, Claims>) Jwts.parser()
                .verifyWith(key)
                .build()
                .parse(token);
    }

    private Claims getClaims(String token) {
        return parseToken(token).getPayload();
    }
}

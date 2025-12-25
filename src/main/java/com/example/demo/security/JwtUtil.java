package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String SECRET_KEY =
            "this_is_a_very_secure_secret_key_for_jwt_testing_123456";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    /* ===================== TOKEN CREATION ===================== */

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateTokenForUser(User user) {
        Map<String, Object> claims = Map.of(
                "userId", user.getId(),
                "email", user.getEmail(),
                "role", user.getRole()
        );

        return generateToken(claims, user.getEmail());
    }

    /* ===================== TOKEN PARSING ===================== */

    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }

    public String extractUsername(String token) {
        return parseToken(token).getBody().getSubject();
    }

    public String extractRole(String token) {
        return (String) parseToken(token).getBody().get("role");
    }

    public Long extractUserId(String token) {
        Object id = parseToken(token).getBody().get("userId");
        if (id instanceof Integer) {
            return ((Integer) id).longValue();
        }
        return (Long) id;
    }

    /* ===================== VALIDATION ===================== */

    public boolean isTokenValid(String token, String username) {
        try {
            String tokenUsername = extractUsername(token);
            return tokenUsername.equals(username);
        } catch (Exception e) {
            return false;
        }
    }
}

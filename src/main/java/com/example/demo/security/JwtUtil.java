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

    private static final String SECRET_KEY =
            "this_is_a_very_secure_secret_key_for_jwt_testing_123456";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;

    // 🔑 MUST be SecretKey (not Key)
    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    /* ================= TOKEN CREATION ================= */

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String generateTokenForUser(User user) {
        return generateToken(
                Map.of(
                        "userId", user.getId(),
                        "email", user.getEmail(),
                        "role", user.getRole()
                ),
                user.getEmail()
        );
    }

    /* ================= TOKEN PARSING ================= */

    // ✅ jjwt 0.12.x compatible
    public Jwt<?, ?> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parse(token);
    }

    // ✅ CAST payload to Claims
    private Claims getClaims(String token) {
        return (Claims) parseToken(token).getPayload();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return (String) getClaims(token).get("role");
    }

    public Long extractUserId(String token) {
        Object id = getClaims(token).get("userId");
        if (id instanceof Integer) {
            return ((Integer) id).longValue();
        }
        return (Long) id;
    }

    public boolean isTokenValid(String token, String username) {
        try {
            return extractUsername(token).equals(username);
        } catch (Exception e) {
            return false;
        }
    }
}

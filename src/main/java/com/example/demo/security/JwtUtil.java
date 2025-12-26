package com.example.demo.security;

import com.example.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // OLD JJWT requires String secret, not Key
    private static final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey";

    // Used in t60_generateJwtToken_containsSubject
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Used in t61–t71
    public String generateTokenForUser(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        claims.put("userId", user.getId());

        return generateToken(claims, user.getEmail());
    }

    public String extractUsername(String token) {
        return parseToken(token).getBody().getSubject();
    }

    public String extractRole(String token) {
        return (String) parseToken(token).getBody().get("role");
    }

    public Long extractUserId(String token) {
        return ((Number) parseToken(token).getBody().get("userId")).longValue();
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username);
    }

    // 🔥 OLD JJWT STYLE — THIS FIXES YOUR ERROR
    public Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
    }
}

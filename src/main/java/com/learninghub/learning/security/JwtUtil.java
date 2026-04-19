package com.learninghub.learning.security;

import java.security.Key;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.learninghub.learning.model.Role;
import com.learninghub.learning.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private final long EXPIRATION = 1000 * 60 * 60;

    public String generateToken(User user) {

        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        List<String> roles = user.getRoles()
            .stream()
            .map(Role::getName)
            .toList();

        return Jwts.builder()
                .subject(user.getUsername())
                .claim("roles", roles)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public String validateTokenAndGetEmail(String token) {

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public Claims extractAllClaims(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
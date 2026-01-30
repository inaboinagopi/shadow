package com.shadowapp.config;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    private static final String SECRET_KEY = "MySuperSecretKeyForJwtGeneration123456"; // Must be 32+ characters
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(String username) {
        logger.info("Generating token for user: {}", username);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10000 * 60 * 60)) // 1-hour expiry
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException e) {
            logger.warn("Invalid JWT token: {}", e.getMessage());
            return null;
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        if (username == null) {
            logger.warn("Token validation failed: username extraction returned null");
            return false;
        }
        boolean isValid = username.equals(userDetails.getUsername()) && !isTokenExpired(token);
        if (!isValid) {
            logger.warn("Invalid token for user: {}", userDetails.getUsername());
        }
        return isValid;
    }

    private boolean isTokenExpired(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration()
                    .before(new Date());
        } catch (ExpiredJwtException e) {
            logger.warn("Token has expired: {}", e.getMessage());
            return true;
        }
    }
}



















































//package com.brd.config;
//
//import java.security.Key;
//import java.util.Date;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//@Component
//public class JwtService {
//	
//    private final String SECRET_KEY = "MySuperSecretKeyForJwtGeneration123456"; // Must be 32+ characters
//
//    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1-hour expiry
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
//                .getBody().getExpiration().before(new Date());
//    }
//}

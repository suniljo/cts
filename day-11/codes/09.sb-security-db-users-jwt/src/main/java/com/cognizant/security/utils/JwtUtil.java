package com.cognizant.security.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {
	SecretKey key = Jwts.SIG.HS256.key().build(); 
    
    public String generateToken(String username) {
        return Jwts.builder()
        		.subject(username)
        		.issuer("Cognizant")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .claim("company", "Cognizant")
                .claim("reportTo","Swetha")
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token)) && !isExpired(token);
    }

    private Claims getClaims(String token) {
    	Claims claims = Jwts.parser()
    		    .verifyWith(key) // 1. Verify Signature
    		    .build()
    		    .parseSignedClaims(token) // 2. Parse payload
    		    .getPayload();
    	// Extract data
    	String subject = claims.getSubject();
    	String customClaim = claims.get("customKey", String.class);
    	
        return claims;
    }

    private boolean isExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }
}
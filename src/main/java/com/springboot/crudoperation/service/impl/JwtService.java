package com.springboot.crudoperation.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.security.secret-key}")
    String secreteKey;

    @Value("${jwt.security.expiry-time}")
    long expiryTime;


    // extractUsername() by passing token

    public String extractName(String token){
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignUpKey()).build().parseClaimsJws(token).getBody();
    }

    public String generateToken(UserDetails userDetails)
    {
        return Jwts.builder().setClaims(new HashMap<>())
                .setSubject(userDetails.getUsername()).
                setExpiration(new Date(System.currentTimeMillis() + expiryTime)).
                setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSignUpKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignUpKey() {
        byte[] keyData = Decoders.BASE64.decode(secreteKey);
        return Keys.hmacShaKeyFor(keyData);
    }

    public long getExpiryTime() {
        return expiryTime;
    }
}

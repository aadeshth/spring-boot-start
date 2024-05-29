package com.springboot.crudoperation.service.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;

@Server
public class JwtService {

    @Value("${jwt.security.secret-key}")
    String secreteKey;

    @Value("${jwt.security.expiry-time}")
    String expiryTime;

    public String generateToken(UserDetails userDetails)
    {
        return Jwts.builder().setSubject(userDetails.getUsername()).
                setExpiration(new Date(System.currentTimeMillis() + expiryTime)).
                setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSignUpKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignUpKey() {
        byte[] keyData = Decoders.BASE64.decode(secreteKey);
        return Keys.hmacShaKeyFor(keyData);
    }
}

package com.api.hiddenMap.utility;

import com.api.hiddenMap.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long jwtExpirationMs;

    private SecretKey key(){
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(UserEntity user){
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role",user.getRole().name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.ES256)
                .compact();
    }

    public String extractEmail(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public String extractRole(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("role",String.class);
    }

    private boolean isTokenExpired(String token){
        return Jwts.parser().setSigningKey(key()).build().parseClaimsJwt(token).getBody().getExpiration().before(new Date());
    }

    public boolean validateToken(String token ,String email){
        return email.equals(extractEmail(token))&& !isTokenExpired(token);
    }
}

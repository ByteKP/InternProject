package com.internproject.ppmtool.Security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.internproject.ppmtool.domain.User;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static com.internproject.ppmtool.Security.SecurityConstraints.EXPIRATION_TIME;
import static com.internproject.ppmtool.Security.SecurityConstraints.SECRET;

@Component
public class JwtTokenProvider {

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        String userId = Long.toString(user.getId());

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", Long.toString(user.getId()));
        claims.put("username", user.getUsername());
        claims.put("fullname", user.getFullName());

        return Jwts.builder().setSubject(userId).setClaims(claims).setIssuedAt(now).setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }
}
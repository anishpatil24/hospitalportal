package com.hospitalportal.hospitalportal.security;

import com.hospitalportal.hospitalportal.Authentication.AuthenticateUser;
import com.hospitalportal.hospitalportal.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    @Autowired
    AuthenticateUser authenticateUser;

    public String generate(JwtUser jwtUser) {

        Boolean check = authenticateUser.validateUser(jwtUser.getUsername(), jwtUser.getPassword());
        if (check == true) {
            Claims claims = Jwts.claims()
                    .setSubject(jwtUser.getUsername());
            claims.put("id", String.valueOf(jwtUser.getId()));
            claims.put("usertype", jwtUser.getUsertype());
            claims.put("password", jwtUser.getPassword());
            return Jwts.builder().setClaims(claims)
                    .signWith(SignatureAlgorithm.HS512, "secretkey")
                    .compact();
        }
        return null;
    }
}

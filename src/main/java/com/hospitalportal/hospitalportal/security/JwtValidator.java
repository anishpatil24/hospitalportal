package com.hospitalportal.hospitalportal.security;


import com.hospitalportal.hospitalportal.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    private String secret = "secretkey";

    public JwtUser  validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
             jwtUser = new JwtUser();
            jwtUser.setUsername(body.getSubject());
            jwtUser.setId(Integer.parseInt((String) body.get("id")));
            jwtUser.setUsertype((String) body.get("usertype"));
        }catch (Exception e)
        {
            System.out.println(e);
        }

        return jwtUser;

    }
}

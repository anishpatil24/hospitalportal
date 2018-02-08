package com.hospitalportal.hospitalportal.controller;

import com.hospitalportal.hospitalportal.model.JwtUser;
import com.hospitalportal.hospitalportal.security.JwtGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/token")
public class TokenController {


    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody JwtUser jwtUser)
    {

        return jwtGenerator.generate(jwtUser);

    }

}


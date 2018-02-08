package com.hospitalportal.hospitalportal.controller;


import com.hospitalportal.hospitalportal.Entity.Login;
import com.hospitalportal.hospitalportal.Repository.LoginRepository;
import com.hospitalportal.hospitalportal.model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/login")
public class LoginController {


    @GetMapping
    public String fetchUserType() {

        return "Success";
    }
}

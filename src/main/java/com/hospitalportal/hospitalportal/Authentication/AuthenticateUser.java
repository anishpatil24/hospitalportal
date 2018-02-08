package com.hospitalportal.hospitalportal.Authentication;

import com.hospitalportal.hospitalportal.Entity.Login;
import com.hospitalportal.hospitalportal.Repository.LoginRepository;
import com.hospitalportal.hospitalportal.model.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthenticateUser {

    @Autowired
    LoginRepository loginRepository;

    public Boolean validateUser(String username, String password) {
        Login user = loginRepository.findByUserName(username);
        if (password.equals(user.getPassword()))
            return true;
        return null;
    }
}

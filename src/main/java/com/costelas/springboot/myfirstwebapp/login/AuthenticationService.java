package com.costelas.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service // ca si @Component but for business logicR
public class AuthenticationService {

    public boolean isAuthenticated(String username,  String password) {

        boolean isValidUsername = username.equalsIgnoreCase("costelas");
        boolean isValidPassword = password.equalsIgnoreCase("sugeo");

        return isValidUsername && isValidPassword;
    }

}

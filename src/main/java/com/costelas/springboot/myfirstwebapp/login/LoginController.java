package com.costelas.springboot.myfirstwebapp.login;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // http://localhost:2002/login?name=costelas
    // @RequestParam makes it, so we get the name parameter for use

    // Model passes the name parameter
    // Whenever we want anything available to the .jsp, we add it to the ModelMap
    @RequestMapping("login")
    public String gotoLoginPage() {

        return "login";
    }
}

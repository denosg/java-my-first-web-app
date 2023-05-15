package com.costelas.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // http://localhost:2002/login?name=costelas
    // @RequestParam makes it so we get the name parameter for use

    // Model passes the name parameter
    // Whenever we want anything available to the .jsp, we add it to the ModelMap
    @RequestMapping("login")
    public String gotoLoginPage(@RequestParam String name, ModelMap modelMap) {
        // adding name to modelMap
        modelMap.put("name", name);
        System.out.println("Request param is "+ name); //NOT RECOMMENDED FOR PROD CODE

        return "login";
    }
}

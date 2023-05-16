package com.costelas.springboot.myfirstwebapp.login;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // http://localhost:2002/login?name=costelas
    // @RequestParam makes it, so we get the name parameter for use

    // Model passes the name parameter
    // Whenever we want anything available to the .jsp, we add it to the ModelMap

    //GET, POST are being handled by this method
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        modelMap.put("name", name);
        modelMap.put("password", password);
        return "welcome";
    }
}

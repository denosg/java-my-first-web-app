package com.costelas.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    // "say-hello" => "Hello! What are you learning today ?"
    // when somebody goes to say-hello, we want to receive this string
    // http://localhost:2002/say-hello
    @RequestMapping("say-hello")
    @ResponseBody // will return whatever is returned by this method as it is to the browser
    public String sayHello() {
        return "Hello! What are you learning today ?";
    }
}

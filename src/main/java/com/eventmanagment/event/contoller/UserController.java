package com.eventmanagment.event.contoller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/signin")
    public String getLoginPage(){
        return "login";

    }
}

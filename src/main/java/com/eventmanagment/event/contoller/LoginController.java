package com.eventmanagment.event.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/web")
public class LoginController {


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String doLoginPage(Object request) {
        return "gallery";
    }


    }





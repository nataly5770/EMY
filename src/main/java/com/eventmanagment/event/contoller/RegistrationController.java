package com.eventmanagment.event.contoller;

import com.eventmanagment.event.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class RegistrationController {


    @GetMapping("/signup")
    public String getSignedUp() {
        return "registration";
    }



    @PostMapping("/registration")

    public String doRegister(@ModelAttribute Registration registration) {
        System.out.println("Registration" + registration.getEmail());

        return "registration";
    }

}



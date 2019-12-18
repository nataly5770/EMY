package com.eventmanagment.event.contoller;

import com.eventmanagment.event.model.User;
import com.eventmanagment.event.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
       User userFromDb = userRepository.findByUsername(user.getUsername());

       if (userFromDb != null){
           model.put("message", "User exists!");
           return "registration";
       }

        return "redirect:/login";
    }
}

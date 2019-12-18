package com.eventmanagment.event.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(
            @RequestParam(name = "name", required = false, defaultValue = "Hello World!") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "home";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
model.put("some", "This is my first Web App!");

        return "main";
    }
}

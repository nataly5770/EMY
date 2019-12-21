package com.eventmanagment.event.contoller;


import com.eventmanagment.event.model.User;
import com.eventmanagment.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String getSignedUp() {
        return "registration";
    }

    @PostMapping("/signup")
    public String createUser(User user) {
        user.setRole(User.Role.ADMIN);
        user.setEnabled(true);
        userService.createUser(user);
        return getLoginPage();
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


}


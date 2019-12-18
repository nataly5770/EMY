package com.eventmanagment.event.contoller;


import com.eventmanagment.event.model.User;
import com.eventmanagment.event.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("user/signin")
    public String getLoginPage(){
        return "user/signin";
    }

        //Мы могли бы расписать эти 2 маппинга отдельно, но смысла дублировать одинаковый код нет.
        // этот метод будет слушать запросы на "/" и "/index"
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


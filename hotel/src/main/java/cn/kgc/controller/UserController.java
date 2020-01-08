package cn.kgc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("toHome")
    public String toHome(){
        return "Home";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }
    @RequestMapping("CityHouse")
    public String MyPoints(){
        return "CityHouse";
    }
}

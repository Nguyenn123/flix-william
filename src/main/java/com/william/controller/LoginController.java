package com.william.controller;


import com.william.entity.LoginEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String showLogin(){
        return "/frontend/signin";
    }

    @GetMapping("/signup")
    public String showSignup(){
        return "/frontend/signup";
    }

}

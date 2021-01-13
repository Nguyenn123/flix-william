package com.william.controller;


import com.william.entity.LoginEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@SessionAttributes("loginentity")
public class LoginController {

    @GetMapping("")
    public String showLogin(){
        return "/frontend/signin";
    }

    @GetMapping("/signup")
    public String showSignup(){
        return "/frontend/signup";
    }

    @ModelAttribute("loginentity")
    public LoginEntity setLoginEntity(){
//        if(!model.containsAttribute("loginentity")) {
//            model.addAttribute("loginentity", new LoginEntity());
//        }
        return new LoginEntity();
    }


}

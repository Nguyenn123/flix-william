package com.william.controller.AdminController;

import com.william.entity.AccountEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {
    @GetMapping
    public ModelAndView home(HttpSession session){
        ModelAndView modelAndView;
        AccountEntity logged = (AccountEntity) session.getAttribute("userLogged");
        if(logged.getRole() == 10001){
            modelAndView = new ModelAndView("/backend/index");
        }
        else {
            modelAndView = new ModelAndView("/frontend/index");
        }
        return modelAndView;
    }

}

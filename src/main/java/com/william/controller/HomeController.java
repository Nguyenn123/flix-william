package com.william.controller;

import com.william.entity.AccountEntity;
import com.william.service.CategoryService;
import com.william.service.ICategoryService;
import com.william.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IVideoService videoService;

    @RequestMapping("/")
    public ModelAndView home(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/frontend/index");
        Optional<AccountEntity> user = (Optional<AccountEntity>) session.getAttribute("userLogged");
        if(user == null){
            return modelAndView;
        }
        modelAndView.addObject("user", user.get());
        return modelAndView;
    }

    @GetMapping("/listCategory")
    public String listCategory(){
        return "backend/listByCategory";
    }
}

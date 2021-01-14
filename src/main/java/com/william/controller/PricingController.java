package com.william.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pricing")
public class PricingController {
    @GetMapping
    public ModelAndView pricing(){
        ModelAndView modelAndView = new ModelAndView("/frontend/pricing");
        return modelAndView;
    }
}

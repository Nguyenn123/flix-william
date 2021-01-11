package com.william.controller.AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class VideoController {
    @RequestMapping("/new-video")
    public ModelAndView addNewVideo(){
        ModelAndView modelAndView = new ModelAndView("/backend/add-item");
        return modelAndView;
    }
}

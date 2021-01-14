package com.william.controller;

import com.william.entity.VideosEntity;
import com.william.service.CategoryService;
import com.william.service.ICategoryService;
import com.william.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IVideoService videoService;

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/frontend/index");
        return modelAndView;
    }

    @GetMapping("/listCategory")
    public String listCategory() {
        return "backend/listByCategory";
    }

    @GetMapping("/details/{id}")
    public String detailsVideo(@PathVariable int id, Model model) {
        VideosEntity videosEntity = (VideosEntity) videoService.findById(id);
        model.addAttribute("videosEntity", videosEntity);
        return "backend/details";
    }
}

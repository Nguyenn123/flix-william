package com.william.controller;

import com.william.entity.VideosEntity;
import com.william.repository.IVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class DetailVideoController {
    @Autowired
    private IVideoRepository videoRepository;
    @RequestMapping("/detail")
    public String detailVideo(@RequestParam(value = "idVideos",required = false) String id, Model model) {
        if (id != null) {
            Optional<VideosEntity> videosEntity = videoRepository.findById(Integer.parseInt(id));
            if (videosEntity!=null){
                model.addAttribute("videosEntity",videosEntity.get());
                return "frontend/details1";
            }
        }
            return "frontend/404";
    }
}

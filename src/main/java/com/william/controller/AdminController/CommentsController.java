package com.william.controller.AdminController;

import com.william.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/comments")
public class CommentsController {

    @GetMapping
    public ModelAndView comments(){
        ModelAndView modelAndView = new ModelAndView("backend/comments");
        return modelAndView;
    }
}

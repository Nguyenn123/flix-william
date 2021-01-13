package com.william.controller.AdminController;

import com.william.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/user")
public class UserController {
    @Autowired
    private IAccountService accountService;


    @GetMapping()
    public String show(){
        return "/backend/users";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("user", accountService.findById(id));
        return "/backend/edit-user";
    }
}

package com.william.controller.AdminController;

import com.william.entity.AccountEntity;
import com.william.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("admin/user")
public class UserController {

//    @GetMapping()
//    public String show(){
//        return "/backend/users";
//    }

    @GetMapping
    public ModelAndView home(HttpSession session){
        ModelAndView modelAndView = null;
        Optional<AccountEntity> logged = (Optional<AccountEntity>) session.getAttribute("userLogged");
        if(logged == null){
            modelAndView = new ModelAndView("redirect:/login");
        } else {
            if(logged.get().getRole() == 10001){
                modelAndView = new ModelAndView("/backend/users");
            }
            else {
                modelAndView = new ModelAndView("/backend/404");
            }
        }
        return modelAndView;
    }
}

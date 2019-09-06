package com.edu.hqu.training.demo.controller;

import com.edu.hqu.training.demo.entity.User;
import com.edu.hqu.training.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private UserService service;

    @Autowired
    public HomeController(UserService service){
        this.service = service;
    }

    @GetMapping("/main")
    public String main(User user, Model model){
        if(user != null){
            model.addAttribute(user);
            model.addAttribute(service.getUserPermissions(user.getUsername()));
        }
        return "main";
    }

    @GetMapping("/test")
    public String error(){
        return "error";
    }
}

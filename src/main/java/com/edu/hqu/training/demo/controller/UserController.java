package com.edu.hqu.training.demo.controller;

import com.edu.hqu.training.demo.entity.User;
import com.edu.hqu.training.demo.entity.form.UserForm;
import com.edu.hqu.training.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/register")
    public String getUserRegister(Model model){
        model.addAttribute(service.getRoles());
        return "user/register";
    }
    @PostMapping("/register")
    public String postUserRegister(UserForm userForm){
        service.addUser(userForm.toUser());
        return "main";
    }

    /*@GetMapping("/login")
    public String getUserLogin(){
        return "user/login";
    }
    @PostMapping("/login")
    public String postUserLogin(String username, String password, HttpSession session){
        User user = service.matchUser(username, password);
        if(user != null){
            session.setAttribute("nameKey", username);
            return "redirect:main";
        }
        return "error";
    }*/

    /*@GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:main";
    }*/

    @GetMapping("/profile")
    public String getProfile(User user, Model model){
        if(user != null){
            model.addAttribute(user);
        }
        return "user/profile";
    }
}

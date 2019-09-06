package com.edu.hqu.training.demo.controller;

import com.edu.hqu.training.demo.entity.form.UserForm;
import com.edu.hqu.training.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    private UserService service;

    @Autowired
    public AdminController(UserService service){
        this.service = service;
    }

    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute(service.getUsers());
        return "admin/users";
    }

    @GetMapping("/user_change")
    public String getUserx(int id, Model model){
        model.addAttribute(service.getRoles());
        model.addAttribute(service.getUserById(id));
        return "admin/userx";
    }
    @PostMapping("/user_change")
    public String postUserx(UserForm userForm){
        service.addUser(userForm.toUser());
        return "status/pass";
    }

    @PostMapping("/user_delete")
    public String deleteUser(int id){
        service.deleteUserById(id);
        return "redirect:users";
    }
}

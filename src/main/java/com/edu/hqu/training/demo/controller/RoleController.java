package com.edu.hqu.training.demo.controller;

import com.edu.hqu.training.demo.entity.form.RoleForm;
import com.edu.hqu.training.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoleController {
    private RoleService service;

    @Autowired
    public RoleController(RoleService service){
        this.service = service;
    }

    @GetMapping("/roles")
    public String getRoles(Model model){
        model.addAttribute(service.getPermissions());
        model.addAttribute(service.getRoleForms());
        return "role/roles";
    }

    @GetMapping("/role_add")
    public String getRolea(Model model){
        model.addAttribute(service.getPermissions());
        return "role/rolea";
    }
    @PostMapping("/role_add")
    public String postRolea(RoleForm roleForm){
        service.addRole(roleForm);
        return "status/pass";
    }

    @GetMapping("role_change")
    public String getRolex(int id, Model model){
        model.addAttribute(service.getPermissions());
        model.addAttribute(service.getRoleForm(id));
        return "role/rolex";
    }
    @PostMapping("role_change")
    public String postRolex(RoleForm roleForm){
        service.changeRole(roleForm);
        return "status/pass";
    }

    @PostMapping("/role_delete")
    public String deleteRole(int id){
        service.deleteRole(id);
        return "redirect:roles";
    }
}

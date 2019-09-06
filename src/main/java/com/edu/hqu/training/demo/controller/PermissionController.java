package com.edu.hqu.training.demo.controller;

import com.edu.hqu.training.demo.entity.Permission;
import com.edu.hqu.training.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PermissionController {
    private PermissionService service;

    @Autowired
    public PermissionController(PermissionService service){
        this.service = service;
    }

    @GetMapping("/permissions")
    public String getPermissions(Model model){
        model.addAttribute(service.getPermissions());
        return "permission/permissions";
    }

    @GetMapping("/permission_add")
    public String getPermissiona(){
        return "permission/permissiona";
    }
    @PostMapping("/permission_add")
    public String postPermissiona(Permission permission){
        service.addPermission(permission);
        return "status/pass";
    }

    @GetMapping("/permission_change")
    public String getPermissionx(int id, Model model){
        model.addAttribute(service.getPermissionById(id));
        return "permission/permissionx";
    }
    @PostMapping("/permission_change")
    public String postPermissionx(Permission permission){
        service.addPermission(permission);
        return "status/pass";
    }

    @PostMapping("permission_delete")
    public String deletePermission(int id){
        service.deletePermissionById(id);
        return "redirect:permissions";
    }
}

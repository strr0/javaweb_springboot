package com.edu.hqu.training.demo.service.impl;

import com.edu.hqu.training.demo.repository.PermissionRepository;
import com.edu.hqu.training.demo.repository.RolePermissionRepository;
import com.edu.hqu.training.demo.entity.Permission;
import com.edu.hqu.training.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public List<Permission> getPermissions(){
        return permissionRepository.findAll();
    }
    public void addPermission(Permission permission){
        if(permission.getIcon() == null){
            permission.setIcon("null");
        }
        permissionRepository.save(permission);
    }
    public Permission getPermissionById(int id){
        return permissionRepository.findOneById(id);
    }
    public void deletePermissionById(int id){
        Permission permission = permissionRepository.findOneById(id);
        rolePermissionRepository.deleteAllByPermission(permission.getName());
        permissionRepository.deleteById(id);
    }
}

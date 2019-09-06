package com.edu.hqu.training.demo.service;

import com.edu.hqu.training.demo.entity.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getPermissions();
    void addPermission(Permission permission);
    Permission getPermissionById(int id);
    void deletePermissionById(int id);
}

package com.edu.hqu.training.demo.service;

import com.edu.hqu.training.demo.entity.Permission;
import com.edu.hqu.training.demo.entity.Role;
import com.edu.hqu.training.demo.entity.form.RoleForm;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    List<RoleForm> getRoleForms();
    List<Permission> getPermissions();
    void addRole(RoleForm roleForm);
    RoleForm getRoleForm(int id);
    void changeRole(RoleForm roleForm);
    void deleteRole(int id);
}

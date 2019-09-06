package com.edu.hqu.training.demo.service.impl;

import com.edu.hqu.training.demo.repository.PermissionRepository;
import com.edu.hqu.training.demo.repository.RolePermissionRepository;
import com.edu.hqu.training.demo.repository.RoleRepository;
import com.edu.hqu.training.demo.repository.UserRepository;
import com.edu.hqu.training.demo.service.RoleService;
import com.edu.hqu.training.demo.entity.Permission;
import com.edu.hqu.training.demo.entity.Role;
import com.edu.hqu.training.demo.entity.RolePermission;
import com.edu.hqu.training.demo.entity.form.RoleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
    public List<RoleForm> getRoleForms(){
        List<RoleForm> result = new ArrayList<>();
        List<Role> roles = getRoles();
        for(Role role : roles){
            List<RolePermission> rolePermissions = rolePermissionRepository.findByRole(role.getName());
            List<String> ps = new ArrayList<>();
            for(RolePermission rp : rolePermissions){
                ps.add(rp.getPermission());
            }
            result.add(new RoleForm(role.getId(), role.getName(), ps));
        }
        return result;
    }
    public List<Permission> getPermissions(){
        return permissionRepository.findAll();
    }
    public void addRole(RoleForm roleForm){
        String name = roleForm.getName();
        String description = roleForm.getDescription();
        roleRepository.save(new Role(name, description));
        for(String permission : roleForm.getPermissions()){
            rolePermissionRepository.save(new RolePermission(name, permission));
        }
    }
    public RoleForm getRoleForm(int id){
        Role role = roleRepository.findOneById(id);
        List<RolePermission> rolePermissions = rolePermissionRepository.findByRole(role.getName());
        List<String> ps = new ArrayList<>();
        for(RolePermission rp : rolePermissions){
            ps.add(rp.getPermission());
        }
        return new RoleForm(role.getId(), role.getName(), role.getDescription(), ps);
    }
    public void changeRole(RoleForm roleForm){
        String name = roleForm.getName();
        roleRepository.save(new Role(roleForm.getId(), name, roleForm.getDescription()));
        rolePermissionRepository.deleteAllByRole(name);
        for(String permission : roleForm.getPermissions()){
            rolePermissionRepository.save(new RolePermission(name, permission));
        }
    }
    public void deleteRole(int id){
        Role role = roleRepository.findOneById(id);
        rolePermissionRepository.deleteAllByRole(role.getName());
        userRepository.deleteAllByRole(role.getName());
        roleRepository.deleteById(id);
    }
}

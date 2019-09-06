package com.edu.hqu.training.demo.service.impl;

import com.edu.hqu.training.demo.repository.PermissionRepository;
import com.edu.hqu.training.demo.repository.RolePermissionRepository;
import com.edu.hqu.training.demo.repository.RoleRepository;
import com.edu.hqu.training.demo.repository.UserRepository;
import com.edu.hqu.training.demo.entity.Permission;
import com.edu.hqu.training.demo.entity.Role;
import com.edu.hqu.training.demo.entity.RolePermission;
import com.edu.hqu.training.demo.entity.User;
import com.edu.hqu.training.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private RoleRepository roleRepository;

    //添加用户
    public void addUser(User user){
        userRepository.save(user);
    }
    //
    public User matchUser(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }
    //
    public List<Permission> getUserPermissions(String username){
        String role = getUserByUsername(username).getRole();
        List<Permission> result = new ArrayList<>();
        List<RolePermission> rolePermissions = rolePermissionRepository.findByRole(role);
        if(rolePermissions != null){
            for(RolePermission rolePermission : rolePermissions){
                Permission permission = permissionRepository.findOneByName(rolePermission.getPermission());
                if(permission != null){
                    result.add(permission);
                }
            }
        }
        return result;
    }
    //
    public User getUserByUsername(String username){
        return userRepository.findOneByUsername(username);
    }
    public User getUserById(int id){
        return userRepository.findOneById(id);
    }
    public void deleteUserById(int id){
        userRepository.deleteById(id);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
}

package com.edu.hqu.training.demo.service;

import com.edu.hqu.training.demo.entity.Permission;
import com.edu.hqu.training.demo.entity.Role;
import com.edu.hqu.training.demo.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User matchUser(String username, String password);
    List<Permission> getUserPermissions(String username);
    User getUserByUsername(String username);
    User getUserById(int id);
    void deleteUserById(int id);
    List<User> getUsers();
    List<Role> getRoles();
}

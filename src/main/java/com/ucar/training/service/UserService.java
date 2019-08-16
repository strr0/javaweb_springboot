package com.ucar.training.service;

import com.ucar.training.entity.User;

import java.util.List;

public interface UserService {
    void addUser(String name, String sex, int age, String password, String likes, String tag, int admin);
    void deleteUser(int id);
    List<User> getUsers();
    User matchUser(String name, String password);
    User getUserByName(String name);
    User getUserById(int id);
    void updateUser(User user);
}

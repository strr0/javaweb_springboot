package com.ucar.training.dao;

import com.ucar.training.entity.User;

import java.util.List;

public interface UserDao {
    void insertData(User user);
    void deleteData(int id);
    void updateData(User user);
    List<User> selectData();
    User matchUser(String name, String password);
    User getUserById(int id);
    User getUserByName(String name);
}

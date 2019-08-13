package com.ucar.training.dao;

import com.ucar.training.entity.User;

import java.util.List;

public interface UserDao {
    void insertData(String name, String sex, int age, String password, String likes, String tag, int admin);
    void deleteData(int id);
    void updateData(int id, String name, String sex, int age, String password, String likes, String tag, int admin);
    List<User> selectData();
}

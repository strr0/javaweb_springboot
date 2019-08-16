package com.ucar.training.mapper;

import com.ucar.training.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //基本的增删改查
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> getUsers();

    //根据用户名返回用户
    User getUserByName(String name);
    //根据用户id返回用户信息
    User getUserById(int id);

    User matchUser(@Param("name") String name, @Param("password") String password);
}

package com.ucar.training.mapper;

import com.ucar.training.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    //基本的增删改查
    @Insert("insert into user(name, sex, age, password, likes, tag, admin)" +
            "values(#{name}, #{sex}, #{age}, #{password}, #{likes}, #{tag}, #{admin})")
    void addUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);

    @Update("update user set name = #{name}, sex = #{sex}, age = #{age}, likes = #{likes}, tag = #{tag}" +
            "where id = #{id}")
    void updateUser(User user);

    @Select("select * from user")
    List<User> getUsers();

    //根据用户名返回用户
    @Select("select * from user where name = #{name}")
    User getUserByName(String name);

    //根据用户id返回用户信息
    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    @Select("select * from user where name = #{name} and password = #{password}")
    User matchUser(@Param("name") String name, @Param("password") String password);
}

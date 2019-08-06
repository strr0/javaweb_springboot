package com.ucar.training.dao;

import com.ucar.training.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users;
    private List<User> admins;

    public UserDAO(){
        users = new ArrayList<>();
        users.add(new User("EnglishName", "女", 21, "123123", "写代码", "no.3"));
        users.add(new User("中文名字", "男", 20, "123123", "撩妹, 写代码", "no.1"));
        users.add(new User("不ok", "女", 22, "123123", "篮球, 足球", "no.2"));

        admins = new ArrayList<>();
    }
    public void userAdd(User user){
        users.add(user);
    }
    public void adminAdd(User admin){
        admins.add(admin);
    }

    public List<User> getUsers() {
        return users;
    }
    public List<User> getAdmins() {
        return admins;
    }
}

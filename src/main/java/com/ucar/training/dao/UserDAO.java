package com.ucar.training.dao;

import com.ucar.training.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users;
    private List<User> admins;

    public UserDAO(){
        users = new ArrayList<>();
        users.add(new User("中文名字", "男", 20, "123123", "撩妹, 写代码", "no.1"));
        users.add(new User("不ok", "女", 22, "123123", "篮球, 足球", "no.2"));
        users.add(new User("EnglishName", "女", 21, "123123", "写代码", "no.3"));

        admins = new ArrayList<>();
        admins.add(new User("root", "男", 21, "password", "写代码", "个性签名"));
    }
    public void userAdd(User user){
        users.add(user);
    }
    public void adminAdd(User admin){
        admins.add(admin);
    }
    public boolean isExistName(String name){
        List<User> list = new ArrayList<>();
        list.addAll(users);
        list.addAll(admins);
        for(User user : list){
            if(name.equals(user.getName())){
                return true;
            }
        }
        return false;
    }
    public User getUserByName(String name){
        for(User user : users){
            if(name.equals(user.getName())){
                return user;
            }
        }
        return null;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setAdmins(List<User> admins) {
        this.admins = admins;
    }
    public List<User> getAdmins() {
        return admins;
    }
}

package com.ucar.training.dao;

import com.ucar.training.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;
    private static List<User> admins;

    //初始化
    public static void initUserDao(){
        users = new ArrayList<>();
        users.add(new User("中文名字", "男", 20, "123123", "撩妹, 写代码", "no.1"));
        users.add(new User("不ok", "女", 22, "123123", "篮球, 足球", "no.2"));
        users.add(new User("EnglishName", "女", 21, "123123", "写代码", "no.3"));
        admins = new ArrayList<>();
        admins.add(new User("root", "男", 21, "password", "写代码", "个性签名"));
    }

    //获取用户列表
    public static List<User> getUsers() {
        return users;
    }
    public static List<User> getAdmins() {
        return admins;
    }

    //用户添加
    public static void userAdd(User user){
        users.add(user);
    }
    public static void adminAdd(User admin){
        admins.add(admin);
    }

    //用户删除
    public static List<User> userDelete(String name){
        for(int i = 0; i < users.size(); i++){
            User user = users.get(i);
            if(name.equals(user.getName())){
                users.remove(i);
                return users;
            }
        }
        return users;
    }

    //判断用户名是否已经存在
    public static boolean isExistName(String name){
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

    //返回用户
    public static User getUserByName(String name){
        for(User user : users){
            if(name.equals(user.getName())){
                return user;
            }
        }
        return null;
    }

    //更改用户信息
    public static void userDataChange(User user){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getName().equals(user.getName())){
                users.set(i, user);
            }
        }
    }

    //用户账户密码匹配
    public static User userMatch(String name, String password){
        if(users != null){
            for(User user : users){
                if(name.equals(user.getName()) && password.equals(user.getPassword())){
                    return user;
                }
            }
        }
        return null;
    }
    //管理员账户密码匹配
    public static boolean adminMatch(String name, String password){
        if(admins != null){
            for(User admin : admins){
                if(name.equals(admin.getName()) && password.equals(admin.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }
}
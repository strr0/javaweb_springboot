package com.ucar.training.service.impl;

import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.entity.User;
import com.ucar.training.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoImpl impl = new UserDaoImpl();

    public void showData(){
        List<User> users = impl.selectData();
        if(users != null){
            for(User user : users){
                System.out.println(user.getName());
            }
        }
    }
}

package com.edu.hqu.training.demo;

import com.edu.hqu.training.demo.service.impl.UserServiceImpl;
import com.edu.hqu.training.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private UserServiceImpl service;

    @Test
    public void contextLoads() {
        User user = service.matchUser("小萌新", "123123");
        Assert.assertNotNull(user);
        service.deleteUserById(user.getId());
        List<User> userList = service.getUsers();
        for(User u : userList){
            System.out.println(u.getUsername());
        }
    }

    @Test
    public void testData(){
        User user = service.getUserByUsername("Java");
        Assert.assertNotNull(user);
    }

    @Test
    public void testData1(){
    }

}

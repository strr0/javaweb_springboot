package com.ucar.training.dao.impl;

import com.ucar.training.Utils.SqlSessionFactoryUtils;
import com.ucar.training.dao.UserDao;
import com.ucar.training.entity.User;
import com.ucar.training.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //MyBatis
    //factory
    private SqlSessionFactoryUtils utils = new SqlSessionFactoryUtils();

    //插入
    public void insertData(User user){
        SqlSession session =utils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(user);
        session.commit();
        session.close();
    }

    //删除
    public void deleteData(int id){
        SqlSession session = utils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(id);
        session.commit();
        session.close();
    }

    //修改
    public void updateData(User user){
        SqlSession session = utils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUser(user);
        session.commit();
        session.close();
    }

    //查询
    public List<User> selectData(){
        List<User> users = null;
        SqlSession session = utils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        users = mapper.getUsers();
        session.close();
        return users;
    }

    //根据用户名返回用户信息
    public User getUserByName(String name){
        SqlSession session = utils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserByName(name);
        session.close();
        return user;
    }
    //根据用户id返回用户信息
    public User getUserById(int id){
        SqlSession session = utils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(id);
        session.close();
        return user;
    }

    //匹配用户名密码
    public User matchUser(String name, String password){
        SqlSession session = utils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.matchUser(name, password);
        session.close();
        return user;
    }
}
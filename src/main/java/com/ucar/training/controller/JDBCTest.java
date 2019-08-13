package com.ucar.training.controller;

import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.service.impl.UserServiceImpl;

public class JDBCTest {

    public static void main(String[] args) {
        //UserDaoImpl userDAO = new UserDaoImpl();
        //Connection conn = userDAO.getConnection();
        //userDAO.closeConnection(conn);
        //userDAO.initData();
        //userDAO.insertData("wasd", "男", 21, "123456", "足球", "wasd", 0);
        //userDAO.updateData(15, "qqq", "女", 100, "123456", "写代码", "ok", 1);
        //userDAO.selectData();
        //System.out.println((userDAO.existName("中文名字")? "存在" : "不存在"));

        UserServiceImpl impl = new UserServiceImpl();
        impl.showData();
    }
}

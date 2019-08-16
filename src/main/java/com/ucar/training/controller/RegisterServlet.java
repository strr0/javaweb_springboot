package com.ucar.training.controller;

import com.ucar.training.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserServiceImpl impl = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置request编码为UTF-8
        //request.setCharacterEncoding("UTF-8");

        //设置response编码为UTF-8
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取表单数据
        String Admin = request.getParameter("admin");
        int admin = Integer.parseInt(Admin);

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String Age = request.getParameter("age");
        int age = Integer.parseInt(Age);
        String password = request.getParameter("password");
        String[] Likes = request.getParameterValues("like");
        String likes = "";
        for(int i = 0; i < Likes.length; i++){
            likes += Likes[i] + ", ";
        }
        likes = likes.substring(0, likes.length()-2);
        String tag = request.getParameter("tag");

        //保存用户信息
        //User user = new User(name, sex, age, password, likes, tag, admin);
        if(impl.getUserByName(name) == null){  //用户名不存在
            //
            impl.addUser(name, sex, age, password, likes, tag, admin);
        }
        else{  //用户名已存在
            out.println("用户已存在");
            return;
        }

        out.println("注册成功");
        out.println("(3s后跳转到注册页面)");
        response.setHeader("refresh", "3;url=RegisterServlet");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        request.getRequestDispatcher("pages/user/register.jsp").forward(request, response);
    }
}
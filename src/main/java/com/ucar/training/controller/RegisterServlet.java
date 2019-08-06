package com.ucar.training.controller;

import com.ucar.training.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    List<User> users;
    List<User> admins;
    @Override
    public void init() throws ServletException {
        //初始化用户列表  需先注册一个用户生效
        users = new ArrayList<>();
        users.add(new User("中文名字", "男", 20, "123123", "撩妹, 写代码", "no.1"));
        users.add(new User("不ok", "女", 22, "123123", "篮球, 足球", "no.2"));
        users.add(new User("EnglishName", "女", 21, "123123", "写代码", "no.3"));
        this.getServletContext().setAttribute("usersKey", users);
        //
        admins = new ArrayList<>();
        admins.add(new User("root", "男", 21, "password", "写代码", "个性签名"));
        this.getServletContext().setAttribute("adminsKey", admins);
        System.out.println("RegisterServlet init.");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置request编码为UTF-8
        request.setCharacterEncoding("UTF-8");

        //设置response编码为UTF-8
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取表单数据
        String admin = request.getParameter("admin");

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String Age = request.getParameter("age");
        int age = Integer.parseInt(Age);
        String password = request.getParameter("password");
        String[] likes = request.getParameterValues("like");
        String like = "";
        for(int i = 0; i < likes.length; i++){
            like += likes[i] + ", ";
        }
        like = like.substring(0, like.length()-2);
        String tag = request.getParameter("tag");

        //保存用户信息
        User user = new User(name, sex, age, password, like, tag);
        if(admin.equals("yes")){
            admins.add(user);
            this.getServletContext().setAttribute("adminsKey", admins);
        }
        else{
            users.add(user);
            this.getServletContext().setAttribute("usersKey", users);
        }


        out.println("注册成功");
        out.println("(3s后跳转到注册页面)");
        response.setHeader("refresh", "3;url=register.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request编码
        request.setCharacterEncoding("UTF-8");
        // response编码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        if(name != null){  // 判断用户名是否存在
            //普通用户
            if(users != null){
                for(User user : users){
                    if(name.compareTo(user.getName()) == 0){
                        out.println("该用户已存在");
                        return;
                    }
                }
            }
            //管理员
            if(admins != null){
                for(User admin : admins){
                    if(name.equals(admin.getName())){
                        out.println("该用户已存在");
                        return;
                    }
                }
            }
            out.println("ok!");
            return;
        }
    }
}

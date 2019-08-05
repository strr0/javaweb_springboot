package com.ucar.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    List<User> users;
    @Override
    public void init() throws ServletException {
        users = new ArrayList<>();
        System.out.println("RegisterServlet init.");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置request编码为UTF-8
        //request.setCharacterEncoding("UTF-8");

        //设置response编码为UTF-8
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取表单数据
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
        users.add(user);
        this.getServletContext().setAttribute("usersKey", users);

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
            if(users != null){
                for(User user : users){
                    if(name.compareTo(user.getName()) == 0){
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

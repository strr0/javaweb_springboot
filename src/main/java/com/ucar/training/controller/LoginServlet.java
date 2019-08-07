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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private List<User> users;
    private List<User> admins;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        //普通用户
        users = (List<User>) this.getServletContext().getAttribute("usersKey");
        if(users != null){
            for(User user : users){
                if(name.equals(user.getName()) && password.equals(user.getPassword())){
                    request.getSession().setAttribute("adminKey", "no");
                    request.getSession().setAttribute("nameKey", name);
                    request.getSession().setAttribute("passwordKey", password);
                    request.setAttribute("userKey", user);
                    request.getRequestDispatcher("/profile.jsp").forward(request, response);
                    //out.println("登录成功");
                    return;
                }
            }
        }
        //管理员
        admins = (List<User>)this.getServletContext().getAttribute("adminsKey");
        if(admins != null){
            for(User admin : admins){
                if(name.equals(admin.getName()) && password.equals(admin.getPassword())){
                    request.getSession().setAttribute("adminKey", "yes");
                    request.getSession().setAttribute("nameKey", name);
                    request.getSession().setAttribute("passwordKey", password);
                    response.sendRedirect("message.jsp");
                    return;
                }
            }
        }

        request.setAttribute("message", "用户名或密码不正确");
        request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
    }
}

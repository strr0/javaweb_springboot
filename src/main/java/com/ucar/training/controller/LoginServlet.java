package com.ucar.training.controller;

import com.ucar.training.dao.UserDAO;
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

    @Override
    public void init() throws ServletException {
        if(UserDAO.getAdmins() == null){
            UserDAO.initUserDao();
            this.getServletContext().setAttribute("adminsKey", UserDAO.getAdmins());
            this.getServletContext().setAttribute("usersKey", UserDAO.getUsers());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        //普通用户
        User user = UserDAO.userMatch(name, password);
        if(user != null){
            //request.getSession().setAttribute("adminKey", "no");
            request.getSession().setAttribute("nameKey", name);
            request.getSession().setAttribute("passwordKey", password);
            request.setAttribute("userKey", user);
            request.getRequestDispatcher("ProfileServlet").forward(request, response);
            //out.println("登录成功");
            return;
        }
        //管理员
        else if(UserDAO.adminMatch(name, password)){
            request.getSession().setAttribute("adminKey", "yes");
            request.getSession().setAttribute("nameKey", name);
            request.getSession().setAttribute("passwordKey", password);
            request.getRequestDispatcher("MessageServlet").forward(request, response);
            return;
        }

        request.setAttribute("message", "用户名或密码不正确");
        request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断是否已经登陆
        String name = (String)request.getSession().getAttribute("nameKey");
        if(name != null){
            //判断是否为管理员
            String admin = (String)request.getSession().getAttribute("adminKey");
            if(admin.equals("yes")){
                request.getRequestDispatcher("MessageServlet").forward(request, response);
                return;
            }
            else{
                User user = UserDAO.getUserByName(name);
                request.setAttribute("userKey", user);
                request.getRequestDispatcher("pages/user/profile.jsp").forward(request, response);
                return;
            }
        }
        request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
    }
}
package com.ucar.training.controller;

import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.entity.User;
import com.ucar.training.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserServiceImpl impl = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = impl.matchUser(name, password);
        if(user != null){
            //request.getSession().setAttribute("adminKey", "no");
            request.getSession().setAttribute("nameKey", name);
            request.getSession().setAttribute("passwordKey", password);
            request.setAttribute("userKey", user);

            if(user.getAdmin() == 0){  //普通用户
                request.getRequestDispatcher("ProfileServlet").forward(request, response);
            }
            else {  //管理员
                request.getSession().setAttribute("adminKey", "yes");
                request.setAttribute("usersKey", impl.getUsers());
                request.getRequestDispatcher("MessageServlet").forward(request, response);
            }

            //out.println("登录成功");
            return;
        }
        else {
            request.setAttribute("message", "用户名或密码不正确");
            request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断是否已经登陆
        String name = (String)request.getSession().getAttribute("nameKey");

        if(name == null){
            request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
        }
        else {
            //判断是否为管理员
            String admin = (String)request.getSession().getAttribute("adminKey");
            if(admin == null){
                User user = impl.getUserByName(name);
                request.setAttribute("userKey", user);
                request.getRequestDispatcher("pages/user/profile.jsp").forward(request, response);
            }
            else{
                request.setAttribute("usersKey", impl.getUsers());
                request.getRequestDispatcher("MessageServlet").forward(request, response);
            }
        }

    }
}
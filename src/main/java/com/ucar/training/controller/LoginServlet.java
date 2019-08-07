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
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        //检测是否有新用户注册
        List<User> users = (List<User>) this.getServletContext().getAttribute("usersKey");
        if(users != null){
            userDAO.setUsers(users);
        }
        List<User> admins = (List<User>)this.getServletContext().getAttribute("adminsKey");
        if(admins != null){
            userDAO.setAdmins(admins);
        }
        //更新
        this.getServletContext().setAttribute("usersKey", userDAO.getUsers());
        this.getServletContext().setAttribute("adminsKey", userDAO.getAdmins());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        //普通用户
        if(userDAO.getUsers() != null){
            for(User user : userDAO.getUsers()){
                if(name.equals(user.getName()) && password.equals(user.getPassword())){
                    request.getSession().setAttribute("adminKey", "no");
                    request.getSession().setAttribute("nameKey", name);
                    request.getSession().setAttribute("passwordKey", password);
                    request.setAttribute("userKey", user);
                    request.getRequestDispatcher("pages/user/profile.jsp").forward(request, response);
                    //out.println("登录成功");
                    return;
                }
            }
        }
        //管理员
        if(userDAO.getAdmins() != null){
            for(User admin : userDAO.getAdmins()){
                if(name.equals(admin.getName()) && password.equals(admin.getPassword())){
                    request.getSession().setAttribute("adminKey", "yes");
                    request.getSession().setAttribute("nameKey", name);
                    request.getSession().setAttribute("passwordKey", password);
                    request.getRequestDispatcher("MessageServlet").forward(request, response);
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
        String name = (String)request.getSession().getAttribute("nameKey");
        String admin = (String)request.getSession().getAttribute("adminKey");
        if(name != null){
            if(admin.equals("yes")){
                request.getRequestDispatcher("MessageServlet").forward(request, response);
                return;
            }
            else{
                User user = userDAO.getUserByName(name);
                request.setAttribute("userKey", user);
                request.getRequestDispatcher("pages/user/profile.jsp").forward(request, response);
                return;
            }
        }
        request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
    }
}

package com.ucar.training.controller;

import com.ucar.training.dao.impl.UserDaoImpl;
import com.ucar.training.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        List<User> users = UserDaoImpl.getUsers();
        if(users == null){
            out.println("无效删除");
            return;
        }
        String admin = (String)request.getSession().getAttribute("adminKey");
        String nameDelete = request.getParameter("nameDelete");

        if(admin.equals("yes")){  //判断是否为管理员操作
            users = UserDaoImpl.userDelete(nameDelete);
            this.getServletContext().setAttribute("usersKey", users);
            out.println("删除成功");
            out.println("(3s后跳转到message页面)");
            response.setHeader("refresh", "3;url=MessageServlet");

        }
        else{
            out.println("sorry, 你没有权限删除");
        }
    }
}

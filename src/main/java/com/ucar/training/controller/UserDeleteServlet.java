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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    UserServiceImpl impl = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String admin = (String)request.getSession().getAttribute("adminKey");

        if(admin.equals("yes")){  //判断是否为管理员操作
            String IdDelete = request.getParameter("idDelete");
            if(IdDelete != null){
                int idDelete = Integer.parseInt(IdDelete);
                impl.deleteUser(idDelete);
                out.println("删除成功");
                out.println("(3s后跳转到message页面)");
                response.setHeader("refresh", "3;url=MessageServlet");
            }
            else{
                out.println("无效删除");
            }
        }
        else{
            out.println("sorry, 你没有权限删除");
        }
    }
}

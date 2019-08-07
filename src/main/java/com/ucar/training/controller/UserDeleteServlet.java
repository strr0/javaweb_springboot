package com.ucar.training.controller;

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
        List<User> users = (List<User>)this.getServletContext().getAttribute("usersKey");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(users == null){
            out.println("无效错误");
            return;
        }
        String admin = (String)request.getSession().getAttribute("adminKey");
        String name = request.getParameter("name");
        if(admin.equals("yes")){
            for(int i = 0; i < users.size(); i++){
                if(name.equals(users.get(i).getName())){
                    users.remove(i);
                    this.getServletContext().setAttribute("usersKey", users);
                    out.println("删除成功");
                    out.println("(3s后跳转到message页面)");
                    response.setHeader("refresh", "3;url=MessageServlet");
                    return;
                }
            }
        }
        else{
            out.println("sorry, 你没有权限删除");
        }
    }
}

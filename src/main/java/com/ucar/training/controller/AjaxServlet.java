package com.ucar.training.controller;

import com.ucar.training.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
    private UserServiceImpl impl = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        if(name != null){
            if(impl.isExistName(name)){
                out.println("该用户名已存在");
                return;
            }
            out.println("ok!");
            return;
        }
    }
}

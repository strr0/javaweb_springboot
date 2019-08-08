package com.ucar.training.controller;

import com.ucar.training.dao.UserDAO;
import com.ucar.training.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        if(UserDAO.getAdmins() == null){
            UserDAO.initUserDao();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/user/profile.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        User user = UserDAO.getUserByName(name);
        request.setAttribute("userKey", user);
        request.getRequestDispatcher("pages/user/profile.jsp").forward(request, response);
    }
}
package com.ucar.training.controller;

import com.ucar.training.dao.UserDAO;
import com.ucar.training.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        List<User> users = (List<User>) this.getServletContext().getAttribute("usersKey");
        List<User> admins = (List<User>)this.getServletContext().getAttribute("adminsKey");
        if(users != null){
            userDAO.setUsers(users);
        }
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
        request.getRequestDispatcher("pages/user/profile.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        User user = userDAO.getUserByName(name);
        request.setAttribute("userKey", user);
        request.getRequestDispatcher("pages/user/profile.jsp").forward(request, response);
    }
}

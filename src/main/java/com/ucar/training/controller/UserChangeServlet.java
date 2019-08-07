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
import java.util.List;

@WebServlet("/UserChangeServlet")
public class UserChangeServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        List<User> users = (List<User>)this.getServletContext().getAttribute("usersKey");
        userDAO.setUsers(users);
        List<User> admins = (List<User>)this.getServletContext().getAttribute("adminsKey");
        userDAO.setAdmins(admins);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String nameChange = request.getParameter("nameChange");
        if(nameChange != null){
            User user = userDAO.getUserByName(nameChange);
            request.setAttribute("userKey", user);
            request.getRequestDispatcher("pages/messageboard/messageChange.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String Age = request.getParameter("age");
        String[] likes = request.getParameterValues("like");
        String tag = request.getParameter("tag");
        User user = userDAO.getUserByName(name);
        if(sex != null){
            user.setSex(sex);
        }
        if(Age != null){
            int age = Integer.parseInt(Age);
            user.setAge(age);
        }
        if(likes != null){
            String like = "";
            for(int i = 0; i < likes.length; i++){
                like += likes[i] + ", ";
            }
            like = like.substring(0, like.length()-2);
            user.setLike(like);
        }
        if(tag != null){
            user.setTag(tag);
        }
        userDAO.userDataChange(user);
        this.getServletContext().setAttribute("usersKey", userDAO.getUsers());
        out.println("修改成功");
        response.setHeader("refresh", "3,url=MessageServlet");
    }
}

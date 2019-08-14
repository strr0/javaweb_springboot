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

@WebServlet("/UserChangeServlet")
public class UserChangeServlet extends HttpServlet {
    private UserServiceImpl impl = new UserServiceImpl();

    /*@Override
    public void init() throws ServletException {
        if(UserDaoImpl.getAdmins() == null){
            UserDaoImpl.initUserDao();
            this.getServletContext().setAttribute("adminsKey", UserDaoImpl.getAdmins());
            this.getServletContext().setAttribute("usersKey", UserDaoImpl.getUsers());
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html;charset=UTF-8");
        String IdChange = request.getParameter("idChange");

        if(IdChange != null){
            int idChange = Integer.parseInt(IdChange);
            User user = impl.getUserById(idChange);
            request.setAttribute("userKey", user);
            request.getRequestDispatcher("pages/admin/messageChange.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String Id = request.getParameter("id");
        int id = Integer.parseInt(Id);
        User user = impl.getUserById(id);
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String Age = request.getParameter("age");
        String[] likes = request.getParameterValues("like");
        String tag = request.getParameter("tag");

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

        impl.updateUser(user);

        out.println("修改成功");
        out.println("(3s后回到message界面)");
        response.setHeader("refresh", "3,url=MessageServlet");
    }
}
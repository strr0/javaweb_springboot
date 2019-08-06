package com.ucar.training.controller;

import com.ucar.training.entity.Message;
import com.ucar.training.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/MessageAddServlet")
public class MessageAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<User> users = (List<User>)this.getServletContext().getAttribute("usersKey");
        String name = request.getParameter("name");
        String mName = request.getParameter("mName");
        String mData = request.getParameter("mData");
        Message message = new Message(mName, mData);

        for(int i = 0; i < users.size(); i++){
            User user = users.get(i);
            if(name.equals(user.getName())){
                user.addMessages(message);
                users.set(i, user);
                //out.println("添加成功");
                request.setAttribute("userKey", user);
            }
        }

        this.getServletContext().setAttribute("usersKey", users);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}

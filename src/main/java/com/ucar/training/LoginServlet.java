package com.ucar.training;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private List<User> users;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        users = (List<User>) this.getServletContext().getAttribute("usersKey");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(users != null){
            for(User user : users){
                if(name.equals(user.getName()) && password.equals(user.getPassword())){
                    request.getSession().setAttribute("nameKey", name);
                    request.getSession().setAttribute("passwordKey", password);
                    this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
                    //out.println("登录成功");
                    return;
                }
            }
        }
        request.setAttribute("message", "用户名或密码不正确");
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}

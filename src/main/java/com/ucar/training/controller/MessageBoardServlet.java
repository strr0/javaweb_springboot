package com.ucar.training.controller;

import com.ucar.training.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MessageBoardServlet")
public class MessageBoardServlet extends HttpServlet {
    private MessageServiceImpl impl = new MessageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("messageBoardKey", impl.getMessage());
        request.getRequestDispatcher("pages/messageboard/messageBoard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = (String)request.getSession().getAttribute("nameKey");
        if(name != null){
            String data = request.getParameter("data");
            impl.addMessage(name, data);
            doGet(request, response);
        }
        else{
            out.println("请先登录...");
            response.setHeader("refresh", "3,url=LoginServlet");
        }
    }
}

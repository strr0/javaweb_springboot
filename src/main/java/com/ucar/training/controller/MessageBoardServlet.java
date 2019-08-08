package com.ucar.training.controller;

import com.ucar.training.dao.MessageDAO;
import com.ucar.training.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MessageBoardServlet")
public class MessageBoardServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        MessageDAO.initMessageDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().setAttribute("messageBoardKey", MessageDAO.getMessages());
        request.getRequestDispatcher("pages/messageboard/messageBoard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = (String)request.getSession().getAttribute("nameKey");
        if(name != null){
            String data = request.getParameter("data");
            Message message = new Message(name, data);
            MessageDAO.addMessageBoard(message);
            doGet(request, response);
        }
        else{
            out.println("请先登录...");
            response.setHeader("refresh", "3,url=LoginServlet");
        }
    }
}

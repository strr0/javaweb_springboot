package com.ucar.training.controller;

import com.ucar.training.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MessageBoardDeleteServlet")
public class MessageBoardDeleteServlet extends HttpServlet {
    private MessageServiceImpl impl = new MessageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Id = request.getParameter("id");
        int id = Integer.parseInt(Id);
        impl.deleteMessage(id);
        response.getWriter().println("删除成功");
        response.setHeader("refresh", "3,url=MessageBoardServlet");
    }
}

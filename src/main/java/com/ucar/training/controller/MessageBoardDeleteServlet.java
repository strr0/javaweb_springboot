package com.ucar.training.controller;

import com.ucar.training.dao.MessageDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MessageBoardDeleteServlet")
public class MessageBoardDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MessageDAO.deleteMessageBoard(id);
        this.getServletContext().setAttribute("messageBoardKey", MessageDAO.getMessages());
        response.getWriter().println("删除成功");
        response.setHeader("refresh", "3,url=MessageBoardServlet");
    }
}

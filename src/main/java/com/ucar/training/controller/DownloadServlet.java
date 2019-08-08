package com.ucar.training.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("name");
        if(fileName != null){
            System.out.println("文件名: " + fileName);
            //设置文件MIME类型
            response.setContentType(getServletContext().getMimeType(fileName));
            //设置Content-Disposition
            response.setHeader("Content-Disposition", "attachment;filename="+fileName);
            //
            String filePath = this.getServletContext().getRealPath("/upload/" + fileName);
            //输入流为项目文件，输出流指向浏览器
            InputStream is=new FileInputStream(filePath);
            ServletOutputStream os =response.getOutputStream();
            //
            int len=-1;
            byte[] b=new byte[1024];
            while((len=is.read(b))!=-1){
                os.write(b,0,len);
            }
            //关闭流
            is.close();
            os.close();
        }
        else{
            String filePath = this.getServletContext().getRealPath("/upload");
            File file = new File(filePath);
            if(file.isDirectory()){
                String[] filenames = file.list();
                request.setAttribute("fileNamesKey", filenames);
            }
            request.getRequestDispatcher("pages/file/download.jsp").forward(request, response);
        }

    }
}

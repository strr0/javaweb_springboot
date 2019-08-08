package com.ucar.training.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/file/upload.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        if(!ServletFileUpload.isMultipartContent(request)){
            out.println("未上传文件");
        }
        //配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024*1024*3);  //临界值
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));   //临时存储路径

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(1024*1024*40);  //最大文件上传值
        upload.setSizeMax(1024*1024*50);  //最大请求值
        upload.setHeaderEncoding("UTF-8");  //中文处理

        //上传路径
        String uploadPath = this.getServletContext().getRealPath(File.separator) + File.separator + "upload";
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }

        //处理上传资源
        try{
            List<FileItem> fileItems = upload.parseRequest(request);
            if(fileItems != null && fileItems.size() > 0){
                for(FileItem item : fileItems){
                    if(!item.isFormField()){
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);
                        System.out.println(filePath);
                        out.println("上传成功");
                    }
                }
            }
        }
        catch (Exception i){
            out.println("上传失败");
        }
    }
}

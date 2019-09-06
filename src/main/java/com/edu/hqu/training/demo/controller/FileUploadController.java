package com.edu.hqu.training.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class FileUploadController {
    @GetMapping("/upload")
    public String getUploadPage(){
        return "file/upload";
    }
    @PostMapping("/upload")
    public String postUploadPage(@RequestPart("file") MultipartFile file) throws Exception {
        file.transferTo(new File(file.getOriginalFilename()));
        return "main";
    }
}

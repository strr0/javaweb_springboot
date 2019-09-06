package com.edu.hqu.training.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@SpringBootApplication
public class DemoApplication {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        String location = System.getProperty("user.dir") + "/src/main/resources/static/img";
        File file = new File(location);
        if(!file.exists()){
            file.mkdirs();
        }
        multipartConfigFactory.setLocation(location);
        return multipartConfigFactory.createMultipartConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

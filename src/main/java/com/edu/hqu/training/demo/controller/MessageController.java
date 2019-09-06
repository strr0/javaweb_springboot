package com.edu.hqu.training.demo.controller;

import com.edu.hqu.training.demo.entity.Message;
import com.edu.hqu.training.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MessageController {
    private MessageService service;

    @Autowired
    public MessageController(MessageService service){
        this.service = service;
    }

    @GetMapping("/messages")
    public String getMessages(Model model){
        model.addAttribute(service.getMessages());
        return "message/messages";
    }

    @PostMapping(value = "/message_add")
    public String addMessage(String data, HttpSession session){
        String username = (String)session.getAttribute("nameKey");
        if(username == null){
            return "redirect:login";
        }
        else{
            Message message = new Message(username, data);
            service.addMessage(message);
            return "redirect:messages";
        }
    }
}

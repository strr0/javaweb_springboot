package com.edu.hqu.training.demo.service.impl;

import com.edu.hqu.training.demo.repository.MessageRepository;
import com.edu.hqu.training.demo.entity.Message;
import com.edu.hqu.training.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessages(){
        return messageRepository.findAll();
    }
    public void addMessage(Message message){
        messageRepository.save(message);
    }
}

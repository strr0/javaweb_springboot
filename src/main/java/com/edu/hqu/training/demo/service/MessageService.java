package com.edu.hqu.training.demo.service;

import com.edu.hqu.training.demo.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMessages();
    void addMessage(Message message);
}

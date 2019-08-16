package com.ucar.training.service;

import com.ucar.training.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMessages();
    void addMessage(String name, String data);
    void deleteMessage(int id);
}

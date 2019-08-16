package com.ucar.training.dao;

import com.ucar.training.entity.Message;

import java.util.List;

public interface MessageDao {
    void insertData(Message message);
    void deleteData(int id);
    List<Message> getMessages();
}

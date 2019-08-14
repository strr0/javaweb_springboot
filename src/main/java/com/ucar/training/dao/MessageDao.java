package com.ucar.training.dao;

import com.ucar.training.entity.Message;

import java.util.List;

public interface MessageDao {
    List<Message> getMessages();
    void addMessageData(String mName, String mData);
    void deleteMessageData(int id);
}

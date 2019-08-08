package com.ucar.training.dao;

import com.ucar.training.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    private static List<Message> messages;

    //初始化
    public static void initMessageDao(){
        messages = new ArrayList<>();
    }
    //获取message
    public static List<Message> getMessages() {
        return messages;
    }
    public static void addMessageBoard(Message message){
        messages.add(message);
    }
}

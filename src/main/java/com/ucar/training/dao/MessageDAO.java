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
    //添加
    public static void addMessageBoard(Message message){
        messages.add(message);
    }
    //删除
    public static void deleteMessageBoard(String date){
        for(int i = 0; i < messages.size(); i++){
            Message message = messages.get(i);
            if(date.equals(message.getmDate())){
                messages.remove(i);
                return;
            }
        }
    }
}

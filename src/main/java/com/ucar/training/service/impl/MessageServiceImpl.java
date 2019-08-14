package com.ucar.training.service.impl;

import com.ucar.training.dao.impl.MessageDaoImpl;
import com.ucar.training.entity.Message;
import com.ucar.training.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageDaoImpl impl = new MessageDaoImpl();

    //获取message列表
    public List<Message> getMessage(){
        return impl.getMessages();
    }

    //添加message
    public void addMessage(String name, String data){
        impl.addMessageData(name, data);
    }

    //删除message
    public void deleteMessage(int id){
        impl.deleteMessageData(id);
    }
}

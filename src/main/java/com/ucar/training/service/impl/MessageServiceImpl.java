package com.ucar.training.service.impl;

import com.ucar.training.dao.impl.MessageDaoImpl;
import com.ucar.training.entity.Message;
import com.ucar.training.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageDaoImpl impl = new MessageDaoImpl();

    //获取message列表
    public List<Message> getMessages(){
        return impl.getMessages();
    }

    //添加message
    public void addMessage(String name, String data){
        Message message = new Message(name, data);
        impl.insertData(message);
    }

    //删除message
    public void deleteMessage(int id){
        impl.deleteData(id);
    }
}

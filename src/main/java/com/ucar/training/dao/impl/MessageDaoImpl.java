package com.ucar.training.dao.impl;

import com.ucar.training.utils.SqlSessionFactoryUtils;
import com.ucar.training.dao.MessageDao;
import com.ucar.training.entity.Message;
import com.ucar.training.mapper.MessageMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MessageDaoImpl implements MessageDao {
    //MyBatis
    //factory
    private SqlSessionFactoryUtils utils = new SqlSessionFactoryUtils();

    //添加留言
    public void insertData(Message message){
        SqlSession session = utils.getSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        mapper.addMessage(message);
        session.commit();
        session.close();
    }

    //删除留言
    public void deleteData(int id){
        SqlSession session = utils.getSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        mapper.deleteMessage(id);
        session.commit();
        session.close();
    }

    //获取留言信息
    public List<Message> getMessages(){
        SqlSession session = utils.getSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        List<Message> messages = mapper.getMessages();
        session.close();
        return messages;
    }
}


package com.ucar.training.mapper;

import com.ucar.training.entity.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {
    @Insert("insert into message(m_name, m_data, m_time)" +
            "values(#{mName}, #{mData}, now())")
    void addMessage(Message message);

    @Delete("delete from message where id = #{id}")
    void deleteMessage(int id);

    @Select("select id as mId, m_name as mName, m_data as mData, m_time as mTime from message")
    List<Message> getMessages();
}

package com.ucar.training;

import com.ucar.training.entity.User;
import com.ucar.training.mapper.UserMapper;
import com.ucar.training.utils.SqlSessionFactoryUtils;
import com.ucar.training.entity.Message;
import com.ucar.training.mapper.MessageMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

//先创建数据库sampledb后执行@Test
public class MybatisTest {
    private SqlSessionFactoryUtils utils = new SqlSessionFactoryUtils();

    //初始化user表
    //@Test
    public void initUserTest(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=UTC",
                    "root",
                    "password");
            ScriptRunner runner = new ScriptRunner(connection);
            Reader reader = Resources.getResourceAsReader("init_user.sql");
            runner.runScript(reader);
            runner.closeConnection();
        }
        catch (ClassNotFoundException c){
            System.out.println("class not found!");
        }
        catch (SQLException s){
            System.out.println("get connection error!");
        }
        catch (IOException i){
            System.out.println("get resource error!");
        }
        finally {
            if(connection != null){
                try{
                    connection.close();
                }
                catch (SQLException s){
                    System.out.println("close connection error!");
                }
            }
        }
    }

    //初始化message表
    //@Test
    public void initMessageTest(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=UTC",
                    "root",
                    "password");
            ScriptRunner runner = new ScriptRunner(connection);
            Reader reader = Resources.getResourceAsReader("init_message.sql");
            runner.runScript(reader);
            runner.closeConnection();
        }
        catch (ClassNotFoundException c){
            System.out.println("class not found!");
        }
        catch (SQLException s){
            System.out.println("get connection error!");
        }
        catch (IOException i){
            System.out.println("get resource error!");
        }
        finally {
            if(connection != null){
                try{
                    connection.close();
                }
                catch (SQLException s){
                    System.out.println("close connection error!");
                }
            }
        }
    }

    @Test
    public void getUsersTest(){
        SqlSession session = utils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(10);
        session.close();
        if(user != null){
            System.out.println(user.getLikes());
        }
    }
    @Test
    public void getMessagesTest(){
        SqlSession session = utils.getSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        List<Message> messages = mapper.getMessages();
        session.close();
        if(messages != null){
            Message message = messages.get(0);
            System.out.println(message.getmId());
            System.out.println(message.getmName());
            System.out.println(message.getmData());
            System.out.println(message.getmTime());
        }
    }
}

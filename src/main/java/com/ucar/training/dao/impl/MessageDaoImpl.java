package com.ucar.training.dao.impl;

import com.ucar.training.dao.MessageDao;
import com.ucar.training.entity.Message;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    //驱动名和数据库url
    private static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=UTC";
    //用户名和密码
    private static final String NAME = "root";
    private static final String PWD = "password";

    static {
        try {
            Class.forName(JDBC_Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //建立Connection
    private Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, NAME, PWD);
        }
        catch (SQLException e){
            System.out.println("Get connection error");
        }
        return connection;
    }

    //断开Connection
    private void closeConnection(Connection conn){
        if(conn != null){
            try{
                conn.close();
            }
            catch (SQLException s){
                System.out.println("Connection close error");
            }
        }
        else {
            System.out.println("connection is null!");
        }
    }

    //断开statement
    private void closeStatement(PreparedStatement stmt){
        if(stmt != null){
            try{
                stmt.close();
            }
            catch (SQLException s){
                System.out.println("Statement close error");
            }
        }
        else {
            System.out.println("statement is null!");
        }
    }

    //String 2 Datetime
    private Date string2datetime(String mTime){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try{
            date = df.parse(mTime);
        }
        catch (ParseException p){
            System.out.println("string 2 datetime error");
        }
        return date;
    }

    //初始化Message
    public void initMessageData(){
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql1 = "drop table if exists message";
            stmt = conn.prepareStatement(sql1);
            stmt.execute();
            System.out.println("删除成功");
            String sql2 = "create table message(" +
                    "id int primary key auto_increment," +
                    "m_name varchar(20) not null," +
                    "m_data varchar(50) not null," +
                    "m_time datetime not null)";
            stmt = conn.prepareStatement(sql2);
            stmt.execute();
            System.out.println("创建成功");
        }
        catch (SQLException s){
            System.out.println("init message error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    //获取message列表
    public List<Message> getMessages(){
        List<Message> messages = null;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "select * from message";
            stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            if(!set.next()){
                //
            }
            else {
                messages = new ArrayList<>();
                do{
                    int mId = set.getInt("id");
                    String mName = set.getString("m_name");
                    String mData = set.getString("m_data");
                    String mTime = set.getTimestamp("m_time").toString();
                    Message message = new Message(mId, mName, mData, mTime);
                    messages.add(message);
                }while (set.next());
            }
            set.close();
        }
        catch (SQLException s){
            System.out.println("get message error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
        return messages;
    }

    //添加message
    public void addMessageData(String mName, String mData){
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "insert into message(m_name, m_data, m_time)" +
                    "values(?, ?, now())";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, mName);
            stmt.setString(2, mData);
            stmt.execute();
        }
        catch (SQLException s){
            System.out.println("add message error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    //删除message
    public void deleteMessageData(int id){
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "delete from message where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        }
        catch (SQLException s){
            System.out.println("delete message error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

}


package com.ucar.training.dao.impl;

import com.ucar.training.dao.UserDao;
import com.ucar.training.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
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

    //写入数据到statement
    private void data2stmt(PreparedStatement stmt, String name, String sex, int age, String password, String likes, String tag, int admin){
        if(stmt != null){
            try{
                stmt.setString(1, name);
                stmt.setString(2, sex);
                stmt.setInt(3, age);
                stmt.setString(4, password);
                stmt.setString(5, likes);
                stmt.setString(6, tag);
                stmt.setInt(7, admin);
            }
            catch (SQLException s){
                System.out.println("Set data error");
            }
        }
    }

    //写出数据到User
    private User result2user(ResultSet set){
        User user = null;
        try{
            int id = set.getInt("id");
            String name = set.getString("name");
            String sex = set.getString("sex");
            int age = set.getInt("age");
            String password = set.getString("password");
            String likes = set.getString("likes");
            String tag = set.getString("tag");
            int admin = set.getInt("admin");
            user = new User(id, name, sex, age, password, likes, tag, admin);
        }
        catch (SQLException s){
            System.out.println("result 2 user error");
        }
        return user;
    }

    //初始化数据库
    public void initData(){
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            //删除user表
            String sql1 = "drop table if exists user";
            stmt = conn.prepareStatement(sql1);
            stmt.execute();
            System.out.println("删除成功");
            //创建user表
            String sql2 = "create table user (" +
                    "id int primary key auto_increment," +
                    "name varchar(20) not null," +
                    "sex varchar(10) not null," +
                    "age int not null," +
                    "password varchar(20) not null," +
                    "likes varchar(20) not null," +
                    "tag varchar(30) not null," +
                    "admin int not null" +
                    ")" +
                    "ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8";
            stmt = conn.prepareStatement(sql2);
            stmt.execute();
            System.out.println("创建成功");
            //插入数据
            String sql3 = "insert into user(name, sex, age, password, likes, tag, admin) " +
                    "values (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql3);
            data2stmt(stmt, "中文名字", "男", 20, "123123", "撩妹, 写代码", "No.1", 0);
            stmt.addBatch();
            data2stmt(stmt, "不ok", "女", 21, "123123", "篮球, 足球", "No.2", 0);
            stmt.addBatch();
            data2stmt(stmt, "EnglishName", "女", 22, "123123", "写代码", "No.3", 0);
            stmt.addBatch();
            data2stmt(stmt, "root", "女", 21, "password", "写代码", "个性签名", 1);
            stmt.addBatch();
            stmt.executeBatch();
            stmt.clearBatch();
            System.out.println("初始化成功");
        }
        catch (SQLException s){
            System.out.println("SQL Exception!");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    //插入
    public void insertData(String name, String sex, int age, String password, String likes, String tag, int admin){
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "insert into user ( name, sex, age, password, likes, tag, admin )" +
                    "values ( ?, ?, ?, ?, ?, ?, ? )";
            stmt = conn.prepareStatement(sql);
            data2stmt(stmt, name, sex, age, password, likes, tag, admin);
            stmt.execute();
            System.out.println("插入成功");
        }
        catch (SQLException s){
            System.out.println("Insert error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    //删除
    public void deleteData(int id){
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "delete from user where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("删除成功");
        }
        catch (SQLException s){
            System.out.println("SQL Exception");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    //修改
    public void updateData(int id, String name, String sex, int age, String password, String likes, String tag, int admin){
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "update user set name = ?, sex = ?, age = ?, password = ?, likes = ?, tag = ?, admin = ? " +
                    "where id = ?";
            stmt = conn.prepareStatement(sql);
            data2stmt(stmt, name, sex, age, password, likes, tag, admin);
            stmt.setInt(8, id);
            stmt.execute();
            System.out.println("修改成功");
        }
        catch (SQLException s){
            System.out.println("update error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }

    //查询
    public List<User> selectData(){
        //存放查询数据
        List<User> users = null;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "select * from user";
            stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            //存放查询数据
            if(!set.next()){
                //查询结果为空
            }
            else {
                users = new ArrayList<>();
                do{
                    if(set.getInt("admin") == 0){
                        User user = result2user(set);
                        users.add(user);
                    }
                }while (set.next());
            }

            set.close();
        }
        catch (SQLException s){
            System.out.println("select error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
            return users;
        }
    }

    //是否存在
    public boolean existName(String name){
        boolean exist = false;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "select count(*) from user where name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet set = stmt.executeQuery();
            if(set.next()){
                int num = set.getInt(1);
                if(num == 0){
                    exist = false;
                }
                else {
                    exist = true;
                }
            }
            set.close();
        }
        catch (SQLException s){
            System.out.println("exist name error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
            return exist;
        }
    }

    //账号密码匹配
    public User matchUser(String name, String password){
        User user = null;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "select * from user where name = ? && password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            ResultSet set = stmt.executeQuery();
            if(set.next()){
                user = result2user(set);
            }
            set.close();
        }
        catch (SQLException s){
            System.out.println("select error??");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
            return user;
        }
    }

    //根据id返回用User
    public User getUserById(int id){
        User user = null;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "select * from user where id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            if (set.next()){
                user = result2user(set);
            }
            set.close();
        }
        catch (SQLException s){
            System.out.println("get user by id error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
            return user;
        }
    }

    //根据用户名返回User
    public User getUserByName(String name){
        User user = null;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "select * from user where name = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet set = stmt.executeQuery();
            if (set.next()){
                user = result2user(set);
            }
            set.close();
        }
        catch (SQLException s){
            System.out.println("get user by name error");
        }
        finally {
            closeStatement(stmt);
            closeConnection(conn);
            return user;
        }
    }
}
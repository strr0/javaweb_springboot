package com.ucar.training.dao.impl;

import com.ucar.training.dao.UserDao;
import com.ucar.training.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //驱动名和数据库url
    private static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/sampledb?useSSL=false&serverTimezone=UTC";
    //用户名和密码
    private static String NAME = "root";
    private static String PWD = "password";

    private static List<User> users;
    private static List<User> admins;

    //建立Connection
    public Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, NAME, PWD);
        }
        catch (ClassNotFoundException c){
            System.out.println("Class Not Found");
        }
        catch (SQLException e){
            System.out.println("Get connection error");
        }
        return connection;
    }

    //断开Connection
    public void closeConnection(Connection conn){
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
    public void closeStatement(PreparedStatement stmt){
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
    public void data2stmt(PreparedStatement stmt, String name, String sex, int age, String password, String likes, String tag, int admin){
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
            String sql3 = "insert into user(name, sex, age, password, likes, tag, admin) values (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql3);
            stmt.setString(1, "中文名字");
            stmt.setString(2, "男");
            stmt.setInt(3, 20);
            stmt.setString(4, "123123");
            stmt.setString(5, "撩妹, 写代码");
            stmt.setString(6, "No.1");
            stmt.setInt(7, 0);
            stmt.addBatch();
            stmt.setString(1, "不ok");
            stmt.setString(2, "女");
            stmt.setInt(3, 21);
            stmt.setString(4, "123123");
            stmt.setString(5, "篮球, 足球");
            stmt.setString(6, "No.2");
            stmt.setInt(7, 0);
            stmt.addBatch();
            stmt.setString(1, "EnglishName");
            stmt.setString(2, "女");
            stmt.setInt(3, 22);
            stmt.setString(4, "123123");
            stmt.setString(5, "写代码");
            stmt.setString(6, "No.3");
            stmt.setInt(7, 0);
            stmt.addBatch();
            stmt.setString(1, "root");
            stmt.setString(2, "女");
            stmt.setInt(3, 21);
            stmt.setString(4, "password");
            stmt.setString(5, "写代码");
            stmt.setString(6, "个性签名");
            stmt.setInt(7, 1);
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
        List<User> users = new ArrayList<>();
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try{
            String sql = "select * from user";
            stmt = conn.prepareStatement(sql);
            ResultSet set = stmt.executeQuery();
            //存放查询数据
            while (set.next()){
                if(set.getInt("admin") == 0){
                    String name = set.getString("name");
                    String sex = set.getString("sex");
                    int age = set.getInt("age");
                    String password = set.getString("password");
                    String likes = set.getString("likes");
                    String tag = set.getString("tag");
                    User user = new User(name, sex, age, password, likes, tag, 0);
                    users.add(user);
                }
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
            set.next();
            int num = set.getInt(1);
            if(num == 0){
                exist = false;
            }
            else {
                exist = true;
            }
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


    //初始化
    public static void initUserDao(){
        users = new ArrayList<>();
        users.add(new User("中文名字", "男", 20, "123123", "撩妹, 写代码", "no.1", 0));
        users.add(new User("不ok", "女", 22, "123123", "篮球, 足球", "no.2", 0));
        users.add(new User("EnglishName", "女", 21, "123123", "写代码", "no.3", 0));
        admins = new ArrayList<>();
        admins.add(new User("root", "男", 21, "password", "写代码", "个性签名", 1));
    }

    //获取用户列表
    public static List<User> getUsers() {
        return users;
    }
    public static List<User> getAdmins() {
        return admins;
    }

    //用户添加
    public static void userAdd(User user){
        users.add(user);
    }
    public static void adminAdd(User admin){
        admins.add(admin);
    }

    //用户删除
    public static List<User> userDelete(String name){
        for(int i = 0; i < users.size(); i++){
            User user = users.get(i);
            if(name.equals(user.getName())){
                users.remove(i);
                return users;
            }
        }
        return users;
    }

    //判断用户名是否已经存在
    public static boolean isExistName(String name){
        List<User> list = new ArrayList<>();
        list.addAll(users);
        list.addAll(admins);
        for(User user : list){
            if(name.equals(user.getName())){
                return true;
            }
        }
        return false;
    }

    //返回用户
    public static User getUserByName(String name){
        for(User user : users){
            if(name.equals(user.getName())){
                return user;
            }
        }
        return null;
    }

    //更改用户信息
    public static void userDataChange(User user){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getName().equals(user.getName())){
                users.set(i, user);
            }
        }
    }

    //用户账户密码匹配
    public static User userMatch(String name, String password){
        if(users != null){
            for(User user : users){
                if(name.equals(user.getName()) && password.equals(user.getPassword())){
                    return user;
                }
            }
        }
        return null;
    }
    //管理员账户密码匹配
    public static boolean adminMatch(String name, String password){
        if(admins != null){
            for(User admin : admins){
                if(name.equals(admin.getName()) && password.equals(admin.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }
}
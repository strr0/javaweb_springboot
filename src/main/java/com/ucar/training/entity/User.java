package com.ucar.training.entity;

public class User {
    private String name;
    private String sex;
    private int age;
    private String password;
    private String like;
    private String tag;
    private int admin;  // 0为普通用户 1为管理员

    public User(){}
    public User(String name, String sex, int age, String password, String like, String tag, int admin){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.like = like;
        this.tag = tag;
        this.admin = admin;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setLike(String like) {
        this.like = like;
    }
    public String getLike() {
        return like;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }
}


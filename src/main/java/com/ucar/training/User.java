package com.ucar.training;

public class User {
    private String name;

    private String sex;
    private int age;
    private String password;

    private String like;
    private String tag;

    public User(){}
    public User(String name, String sex, int age, String password, String like, String tag){
        this.name = name;

        this.sex = sex;
        this.age = age;
        this.password = password;

        this.like = like;
        this.tag = tag;
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


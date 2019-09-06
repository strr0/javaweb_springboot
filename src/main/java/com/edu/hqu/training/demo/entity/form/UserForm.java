package com.edu.hqu.training.demo.entity.form;

import com.edu.hqu.training.demo.entity.User;

public class UserForm {
    private Integer id;
    private String username;
    private String sex;
    private int age;
    private String password;
    private String confirmpwd;
    private String[] likes;
    private String signature;
    private String role;

    private String toUserLikes(){
        String LIKES = "";
        if(likes != null){
            for(String like : likes){
                LIKES += like + ", ";
            }
            LIKES = LIKES.substring(0, LIKES.length() - 2);
        }
        return LIKES;
    }

    public User toUser(){
        String LIKES = toUserLikes();
        return new User(id, username, sex, age, password, LIKES, signature, role);
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
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
    public void setConfirmpwd(String confirmpwd) {
        this.confirmpwd = confirmpwd;
    }
    public String getConfirmpwd() {
        return confirmpwd;
    }
    public void setLikes(String[] likes) {
        this.likes = likes;
    }
    public String[] getLikes() {
        return likes;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getSignature() {
        return signature;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}

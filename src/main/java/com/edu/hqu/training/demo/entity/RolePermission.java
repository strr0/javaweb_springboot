package com.edu.hqu.training.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String role;
    private String permission;

    public RolePermission() {}
    public RolePermission(String role, String permission){
        this.role = role;
        this.permission = permission;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }
    public String getPermission() {
        return permission;
    }
}

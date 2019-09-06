package com.edu.hqu.training.demo.entity.form;

import java.util.List;

public class RoleForm {
    private Integer id;
    private String name;
    private String description;
    private List<String> permissions;

    public RoleForm() {}
    public RoleForm(Integer id, String name, List<String> permissions){
        this(id, name, null, permissions);
    }
    public RoleForm(Integer id, String name, String description, List<String> permissions){
        this.id = id;
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
    public List<String> getPermissions() {
        return permissions;
    }
}

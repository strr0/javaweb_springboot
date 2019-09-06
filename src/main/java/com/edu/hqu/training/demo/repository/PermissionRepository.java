package com.edu.hqu.training.demo.repository;

import com.edu.hqu.training.demo.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    List<Permission> findAll();
    Permission findOneByName(String name);
    Permission findOneById(Integer id);
    void deleteById(Integer id);
}

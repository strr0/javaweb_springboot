package com.edu.hqu.training.demo.repository;

import com.edu.hqu.training.demo.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {
    List<RolePermission> findByRole(String role);
    void deleteAllByRole(String role);
    void deleteAllByPermission(String permission);
}

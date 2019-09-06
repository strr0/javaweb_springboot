package com.edu.hqu.training.demo.repository;

import com.edu.hqu.training.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findAll();
    Role findOneById(Integer id);
    void deleteById(Integer id);
}

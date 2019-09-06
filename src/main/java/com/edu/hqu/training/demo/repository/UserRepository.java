package com.edu.hqu.training.demo.repository;

import com.edu.hqu.training.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();
    User findByUsernameAndPassword(String username, String password);
    User findOneByUsername(String username);
    User findOneById(Integer id);
    void deleteById(Integer id);
    void deleteAllByRole(String role);
}

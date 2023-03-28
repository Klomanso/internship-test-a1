package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
        Boolean existsByAccountName(String name);
        Login findByAccountName(String name);
}

package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
        Application findByName(String name);
}

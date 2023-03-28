package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
        Department findByName(String name);
}

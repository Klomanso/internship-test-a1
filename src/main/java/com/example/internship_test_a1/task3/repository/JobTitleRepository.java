package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
        JobTitle findByName(String name);
}

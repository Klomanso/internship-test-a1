package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, String> {
        Posting findByMatDoc(String matDoc);
}

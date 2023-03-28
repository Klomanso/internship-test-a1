package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.PostingDetails;
import com.example.internship_test_a1.task3.model.utility.CompositePDetailsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingDetailsRepository extends JpaRepository<PostingDetails, CompositePDetailsId> {
}

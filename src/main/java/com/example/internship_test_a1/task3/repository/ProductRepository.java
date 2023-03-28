package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
        Product findByDescription(String materialDescription);
}

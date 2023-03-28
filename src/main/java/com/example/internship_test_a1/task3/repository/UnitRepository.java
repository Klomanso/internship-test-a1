package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
        Unit findByName(String name);
}

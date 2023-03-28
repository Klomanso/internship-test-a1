package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
        Currency findByName(String name);
}

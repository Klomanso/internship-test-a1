package com.example.internship_test_a1.task3.service;

import com.example.internship_test_a1.task3.model.Posting;

import java.util.List;

public interface IPostingService {
        List<Posting> findAllByDay(Integer D, Boolean auth);
}

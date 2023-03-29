package com.example.internship_test_a1.task3.service;

import com.example.internship_test_a1.task3.model.Posting;
import com.example.internship_test_a1.task3.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostingService implements IPostingService {

        private final PostingRepository postingRepository;

        @Autowired
        public PostingService(PostingRepository postingRepository) {
                this.postingRepository = postingRepository;
        }

        public List<Posting> findAll() {
                return postingRepository.findAll();
        }

        @Override
        public List<Posting> findAllByDay(Integer D, Boolean auth) {
                return postingRepository.findPostingsByDay(D, auth);
        }
}

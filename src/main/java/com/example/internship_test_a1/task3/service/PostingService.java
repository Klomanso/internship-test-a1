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

        @Override
        public List<Posting> findAllByDay(Integer d, Boolean auth) {
                return postingRepository.findPostingsByDay(d, auth);
        }

        @Override
        public List<Posting> findAllByYear(Integer y, Boolean auth) {
                return postingRepository.findPostingsByYear(y, auth);
        }

        @Override
        public List<Posting> findAllByQuarter(Integer q, Boolean auth) {
                return postingRepository.findPostingsByQuarter(q, auth);
        }

        @Override
        public List<Posting> findAllByMonth(Integer m, Boolean auth) {
                return  postingRepository.findPostingsByMonth(m, auth);
        }
}

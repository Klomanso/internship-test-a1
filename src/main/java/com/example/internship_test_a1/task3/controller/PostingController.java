package com.example.internship_test_a1.task3.controller;

import com.example.internship_test_a1.task3.model.Posting;
import com.example.internship_test_a1.task3.service.PostingService;
import lombok.AllArgsConstructor;
import org.hibernate.sql.ast.tree.predicate.BooleanExpressionPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postings/period")
public class PostingController {

        private final PostingService postingService;

        @Autowired
        public PostingController(PostingService postingService) {
                this.postingService = postingService;
        }

        @GetMapping("/day/{D}")
        public List<Posting> findAllByDay(@PathVariable Integer D,
                                          @RequestParam(required = false, defaultValue = "false") Boolean auth) {
                return postingService.findAllByDay(D, auth);
        }

        @GetMapping("/month/{M}")
        public List<Posting> findAllByMonth(@PathVariable String M) {
                return null;
        }

        @GetMapping("/quarter/{Q}")
        public List<Posting> findAllByQuarter(@PathVariable String Q) {
                return null;
        }

        @GetMapping("/year/{Y}")
        public List<Posting> findAllByYear(@PathVariable String Y) {
                return null;
        }
}

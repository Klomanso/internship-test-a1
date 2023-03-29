package com.example.internship_test_a1.task3.controller;

import com.example.internship_test_a1.task3.model.Posting;
import com.example.internship_test_a1.task3.service.PostingService;
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
        public List<Posting> findAllByMonth(@PathVariable Integer M,
                                            @RequestParam(required = false, defaultValue = "false") Boolean auth) {
                return postingService.findAllByMonth(M, auth);
        }

        @GetMapping("/quarter/{Q}")
        public List<Posting> findAllByQuarter(@PathVariable Integer Q,
                                              @RequestParam(required = false, defaultValue = "false") Boolean auth) {
                return postingService.findAllByQuarter(Q, auth);
        }

        @GetMapping("/year/{Y}")
        public List<Posting> findAllByYear(@PathVariable Integer Y,
                                           @RequestParam(required = false, defaultValue = "false") Boolean auth) {
                return postingService.findAllByYear(Y, auth);
        }
}

package com.example.internship_test_a1;

import com.example.internship_test_a1.task3.service.DataLoadingService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class InternshipTestA1Application implements CommandLineRunner {

        DataLoadingService dataLoadingService;
        public static void main(String[] args) {
                SpringApplication.run(InternshipTestA1Application.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
                dataLoadingService.LoadData();
        }
}

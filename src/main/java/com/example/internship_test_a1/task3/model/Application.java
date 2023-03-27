package com.example.internship_test_a1.task3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {

        @Id
        @Column(name = "app_no")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer appNumber;

        @Column(name = "app_name", nullable = false)
        private String name;
}

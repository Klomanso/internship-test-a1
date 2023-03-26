package com.example.internship_test_a1.task3.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "titles")
public class JobTitle {

        @Id
        @Column(name = "title_no")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer titleNumber;

        @Column(name = "title_name", nullable = false)
        private String name;
}

package com.example.internship_test_a1.task3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "currencies")
public class Currency {

        @Id
        @Column(name = "curr_no")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer currNumber;

        @Column(name = "curr_name", nullable = false)
        private String name;
}

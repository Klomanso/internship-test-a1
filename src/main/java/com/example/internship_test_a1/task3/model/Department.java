package com.example.internship_test_a1.task3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department {


        @Id
        @Column(name = "dept_no")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer depNumber;

        @Column(name = "dept_name", nullable = false)
        private String name;

        public Department(String name) {
                this.name = name;
        }
}

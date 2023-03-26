package com.example.internship_test_a1.task3.model.reference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "units")
public class Unit {

        @Id
        @Column(name = "unit_no")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer unitNumber;

        @Column(name = "unit_name", nullable = false)
        private String name;
}

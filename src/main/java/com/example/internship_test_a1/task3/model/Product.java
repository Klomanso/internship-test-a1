package com.example.internship_test_a1.task3.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

        @Id
        @Column(name = "product_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "description", nullable = false)
        private String description;

        public Product(String description) {
                this.description = description;
        }
}

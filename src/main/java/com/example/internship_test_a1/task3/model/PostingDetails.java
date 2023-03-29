package com.example.internship_test_a1.task3.model;

import com.example.internship_test_a1.task3.model.utility.CompositePDetailsId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@IdClass(CompositePDetailsId.class)
@Table(name = "posting_details")
public class PostingDetails {

        @Id
        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "mat_doc", referencedColumnName = "mat_doc")
        private Posting posting;

        @Id
        @Column(name = "item")
        private Integer item;

        @ManyToOne
        @JoinColumn(name = "product_id", referencedColumnName = "product_id")
        private Product product;

        @Column(name = "quantity")
        private Long quantity;

        @ManyToOne
        @JoinColumn(name = "unit_no", referencedColumnName = "unit_no")
        private Unit unit;

        @Column(name = "amount_lc")
        private Double amountLC;

}

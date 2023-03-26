package com.example.internship_test_a1.task3.model.utility;

import com.example.internship_test_a1.task3.model.Posting;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CompositePDetailsId implements Serializable {

        /*
        * The Embeddable Class for composite key
        * */

        @ManyToOne
        @JoinColumn(name = "mat_doc", referencedColumnName = "mat_doc")
        private Posting posting;

        @Column(name = "item")
        private Integer item;
}

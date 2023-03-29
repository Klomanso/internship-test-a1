package com.example.internship_test_a1.task3.model.utility;

import com.example.internship_test_a1.task3.model.Posting;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompositePDetailsId implements Serializable {

        private Posting posting;
        private Integer item;
}

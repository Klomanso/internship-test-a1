package com.example.internship_test_a1.task3.model;

import com.example.internship_test_a1.task3.model.reference.Currency;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "postings")
public class Posting {

        @Id
        @Column(name = "mat_doc")
        private String matDoc;

        @Column(name = "doc_date")
        @Temporal(TemporalType.DATE)
        private Date docDate;

        @Column(name = "pstng_date")
        @Temporal(TemporalType.DATE)
        private Date postingDate;

        @ManyToOne
        @JoinColumn(name = "curr_no", referencedColumnName = "curr_no")
        private Currency currency;

        @ManyToOne
        @JoinColumn(name = "login_id", referencedColumnName = "login_id")
        private Login login;

        @Column(name = "authorized")
        private Boolean authorized;
}

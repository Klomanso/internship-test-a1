package com.example.internship_test_a1.task3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
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

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "mat_doc")
        @OnDelete(action = OnDeleteAction.CASCADE)
        private List<PostingDetails> postingDetails;

}

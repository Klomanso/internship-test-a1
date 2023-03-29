package com.example.internship_test_a1.task3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "logins")
public class Login {

        @Id
        @Column(name = "login_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @ManyToOne
        @JoinColumn(name = "app_no", referencedColumnName = "app_no")
        private Application application;

        @Column(name = "app_account_name", unique = true)
        private String accountName;

        @Column(name = "is_active")
        private Boolean isActive;

        @ManyToOne
        @JoinColumn(name = "dept_no", referencedColumnName = "dept_no")
        private Department department;

        @ManyToOne
        @JoinColumn(name = "title_no", referencedColumnName = "title_no")
        private JobTitle title;

        @JsonBackReference
        @OneToMany(mappedBy = "login", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @OnDelete(action = OnDeleteAction.NO_ACTION)
        private List<Posting> postings;

}

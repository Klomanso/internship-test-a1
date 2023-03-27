package com.example.internship_test_a1.task3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

        @Column(name = "app_account_name")
        private String accountName;

        @Column(name = "is_active")
        private Boolean isActive;

        @ManyToOne
        @JoinColumn(name = "dept_no", referencedColumnName = "dept_no")
        private Department department;

        @ManyToOne
        @JoinColumn(name = "title_no", referencedColumnName = "title_no")
        private JobTitle title;
}

package com.example.internship_test_a1.task3.model;

import com.example.internship_test_a1.task3.model.reference.Application;
import com.example.internship_test_a1.task3.model.reference.Department;
import com.example.internship_test_a1.task3.model.reference.JobTitle;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

package com.example.internship_test_a1.task3.repository;

import com.example.internship_test_a1.task3.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, String> {
        Posting findByMatDoc(String matDoc);

        @Query(value = "select p from Posting p where day(p.postingDate) = :day and p.authorized = :auth")
        List<Posting> findPostingsByDay(@Param("day") Integer day, @Param("auth") Boolean auth);

        @Query(value = "select p from Posting p where month(p.postingDate) = :month and p.authorized = :auth")
        List<Posting> findPostingsByMonth(@Param("month") Integer month, @Param("auth") Boolean auth);

        @Query(value = "select p from Posting p where quarter(p.postingDate) = :quarter and p.authorized = :auth")
        List<Posting> findPostingsByQuarter(@Param("quarter") Integer quarter, @Param("auth") Boolean auth);

        @Query(value = "select p from Posting p where year(p.postingDate) = :year and p.authorized = :auth")
        List<Posting> findPostingsByYear(@Param("year") Integer year, @Param("auth") Boolean auth);
}

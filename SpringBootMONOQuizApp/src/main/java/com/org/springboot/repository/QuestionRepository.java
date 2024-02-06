package com.org.springboot.repository;

import com.org.springboot.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {
    List<Questions> findByCategory(String category);

    @Query(value = "Select * from questions q where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Questions> findRandomQByCategory(@Param("category") String category, @Param("numQ") int numQ);
}

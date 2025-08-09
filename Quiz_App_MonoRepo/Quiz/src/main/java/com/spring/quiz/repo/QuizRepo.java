package com.spring.quiz.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.quiz.entities.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}

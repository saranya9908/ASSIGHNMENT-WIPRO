package com.spring.quiz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.quiz.enums.Category;
import com.spring.quiz.enums.DifficultyLevel;
import com.spring.quiz.entities.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

	List<Question> findByCategoryAndDifficultyLevel(Category category, DifficultyLevel difficultyLevel);

	@Query(value = "SELECT * FROM question q WHERE q.category = :category AND q.difficulty_level = :difficulty ORDER BY RAND() LIMIT 3", nativeQuery = true)

	List<Question> findRandomQuestionsByCategoryAndLevel(Category category, DifficultyLevel difficultyLevel);

	
}

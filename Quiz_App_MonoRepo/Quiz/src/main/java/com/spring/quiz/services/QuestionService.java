package com.spring.quiz.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.quiz.enums.Category;
import com.spring.quiz.enums.DifficultyLevel;
import com.spring.quiz.entities.Question;

public interface QuestionService {

	Question save(Question question);

	List<Question> findByCategoryAndDifficultyLevel(Category category, DifficultyLevel difficultyLevel);

	Question patchQuestion(Integer id, Question question);

	void deleteQuestionById(Integer id);

	Question getQuestionById(Integer id);

	Page<Question> findAllQuestions(Pageable pageable);

	

}

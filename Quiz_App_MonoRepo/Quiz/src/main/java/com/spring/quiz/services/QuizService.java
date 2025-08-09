package com.spring.quiz.services;

import java.util.List;

import com.spring.quiz.entities.QuestionWrapper;
import com.spring.quiz.entities.Quiz;
import com.spring.quiz.entities.Response;
import com.spring.quiz.enums.Category;
import com.spring.quiz.enums.DifficultyLevel;

public interface QuizService {

	Quiz createQuiz(Category category, DifficultyLevel difficultyLevel, String quizTitle);

	List<QuestionWrapper> getQuizQuestions(Integer id);

	Integer	calculateResult(int id, List<Response> responses);

}

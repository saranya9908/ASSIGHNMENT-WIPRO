package com.spring.quiz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.quiz.entities.Question;
import com.spring.quiz.entities.QuestionWrapper;
import com.spring.quiz.entities.Quiz;
import com.spring.quiz.entities.Response;
import com.spring.quiz.enums.Category;
import com.spring.quiz.enums.DifficultyLevel;
import com.spring.quiz.repo.QuestionRepo;
import com.spring.quiz.repo.QuizRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
	
	private final QuestionRepo questionRepo;
	
	private final QuizRepo quizRepo;

	@Override
	public Quiz createQuiz(Category category, DifficultyLevel difficultyLevel, String quizTitle) {
		
		List<Question> questions=questionRepo.findByCategoryAndDifficultyLevel(category,difficultyLevel);
		
		Quiz quiz = new Quiz();
		
		quiz.setQuizTitle(quizTitle);
		quiz.setQuestions(questions);
		
		return quizRepo.save(quiz);
	}
	

	@Override
	public List<QuestionWrapper> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizRepo.findById(id);
		List<Question> questionFromDB=quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser=new ArrayList<>();
		for (Question q : questionFromDB) {
			QuestionWrapper qw =  new QuestionWrapper(q.getQuestionId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		return questionsForUser;
	}

	@Override
	public Integer calculateResult(int id, List<Response> responses) {
		Quiz quiz = quizRepo.findById(id).get();
		List<Question> questions =quiz.getQuestions();
		int right=0;
		
		for(Response response : responses) {
			for(Question question : questions) {
				if(question.getQuestionId() ==response.getId()) {
					if(question.getCorrectAnswer().equalsIgnoreCase(response.getResponse())) {
						right++;
					}
					break;
				}
			}
		}
		return right;
	}

}

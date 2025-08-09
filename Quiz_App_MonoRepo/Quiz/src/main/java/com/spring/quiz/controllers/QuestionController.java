package com.spring.quiz.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.quiz.enums.Category;
import com.spring.quiz.enums.DifficultyLevel;
import com.spring.quiz.entities.Question;
import com.spring.quiz.services.QuestionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/question")
public class QuestionController {
	
	private final QuestionService questionService;
	
	@PostMapping("/addNewQuestion")
	public Question addQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }
	
	@GetMapping("/getQuestionById/{id}")
    public Question getQuestionById(@PathVariable Integer id) {
        return questionService.getQuestionById(id);
    }
	
    
    @GetMapping("/getAllQuestions")
    public Page<Question> getAllQuestionsPage(Pageable pageable) {
        return questionService.findAllQuestions(pageable);
    }

    @GetMapping("/getBYCatDiff")
    public List<Question> findByCategoryAndDifficultyLevel(
        @RequestParam Category category,
        @RequestParam DifficultyLevel difficultyLevel) {
        return questionService.findByCategoryAndDifficultyLevel(category, difficultyLevel);
    }
    
    @PatchMapping("/patchQuestionById/{id}")
    public Question patch(@PathVariable Integer id, @RequestBody Question question) {
        return questionService.patchQuestion(id, question);
    }
    
    @DeleteMapping("/deleteQuestionById/{id}")
	public String deleteQuestion(@PathVariable Integer id) {
		
		questionService.deleteQuestionById(id);
		return "Question Deleted Successfully";
	}

}

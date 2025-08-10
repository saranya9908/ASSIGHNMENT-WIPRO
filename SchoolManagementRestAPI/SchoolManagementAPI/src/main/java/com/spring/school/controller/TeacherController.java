package com.spring.school.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.spring.school.entities.Teacher;
import com.spring.school.entities.enums.Qualification;
import com.spring.school.services.TeacherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TeacherController {
	
	
    private final TeacherService teacherService;

    // Custom method 1
    @GetMapping("/experienced/{years}")
    public List<Teacher> getExperiencedTeachers(@PathVariable int years) {
        return teacherService.findByExperienceGreaterThan(years);
    }

    // Custom method 2
    @GetMapping("/qualified/{qualification}")
    public List<Teacher> getByQualification(@PathVariable Qualification qualification) {
        return teacherService.findByQualification(qualification);
    }
    
}

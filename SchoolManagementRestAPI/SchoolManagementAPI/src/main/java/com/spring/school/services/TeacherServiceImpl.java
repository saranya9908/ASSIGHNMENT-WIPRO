package com.spring.school.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.school.entities.Teacher;
import com.spring.school.entities.enums.Qualification;
import com.spring.school.repo.TeacherRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
	
	private final TeacherRepo teacherRepo;
	

	@Override
	public List<Teacher> findByExperienceGreaterThan(int years) {
		// TODO Auto-generated method stub
		return teacherRepo.findByExperienceGreaterThan(years);
	}

	@Override
	public List<Teacher> findByQualification(Qualification qualification) {
		// TODO Auto-generated method stub
		return teacherRepo.findByQualification(qualification);
	}

}

package com.spring.school.services;

import java.util.List;

import com.spring.school.entities.Teacher;
import com.spring.school.entities.enums.Qualification;

public interface TeacherService {


	List<Teacher> findByExperienceGreaterThan(int years);

	List<Teacher> findByQualification(Qualification qualification);

}

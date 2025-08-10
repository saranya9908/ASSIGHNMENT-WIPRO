package com.spring.student.service;

import java.util.List;

import com.spring.student.entities.Student;



public interface StudentService {
	
	public List<Student> getAll();

	public void save(Student student);

	public Student getById(Integer id);

	public void delete(Integer id);


}

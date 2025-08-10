package com.spring.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.student.entities.Student;
import com.spring.student.repo.StudentRepo;



@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAll() {
		
		return studentRepo.findAll();
		
	}

	@Override
	public void save(Student student) {
		studentRepo.save(student);
		
	}

	@Override
	public Student getById(Integer id) {
		
		return studentRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		studentRepo.deleteById(id);
		
	}

	
}

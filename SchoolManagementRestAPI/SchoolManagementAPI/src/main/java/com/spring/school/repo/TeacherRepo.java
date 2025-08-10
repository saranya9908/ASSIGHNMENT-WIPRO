package com.spring.school.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.school.entities.Teacher;
import com.spring.school.entities.enums.Qualification;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

	// Custom method 1: Find teachers by experience greater than X
    List<Teacher> findByExperienceGreaterThan(int experience);

    // Custom method 2: Find teachers by qualification
    List<Teacher> findByQualification(Qualification qualification);

 // Native SQL Query 1: Get teachers older than a specific age
    @Query(value = "SELECT * FROM teacher WHERE age > ?1", nativeQuery = true)
    List<Teacher> findTeachersOlderThan(int age);

    // Native SQL Query 2: Get teachers with a specific qualification and more than X years experience
    @Query(value = "SELECT * FROM teacher WHERE qualification = ?1 AND experience > ?2", nativeQuery = true)
    List<Teacher> findQualifiedExperiencedTeachers(String qualification, int experience);


	
	
	


}

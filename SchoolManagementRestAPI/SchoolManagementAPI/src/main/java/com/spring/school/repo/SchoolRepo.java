package com.spring.school.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.school.entities.School;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {

	// Custom Native SQL Query 1
    @Query(value = "SELECT * FROM school WHERE school_name = ?1", nativeQuery = true)
    School findBySchoolNameNative(String name);

    // Custom Native SQL Query 2
    @Query(value = "SELECT COUNT(*) FROM school", nativeQuery = true)
    int countAllSchools();
}

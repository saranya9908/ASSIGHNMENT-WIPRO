package com.spring.school.entities;

import java.time.LocalDate;

import com.spring.school.entities.enums.Qualification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherName;
    
    private String teacherAddress;
    
    private Qualification qualification;
    
    private int age;
    
    private LocalDate dob;
    
    private int experience;

}

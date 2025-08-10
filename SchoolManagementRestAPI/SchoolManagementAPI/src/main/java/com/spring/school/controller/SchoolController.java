package com.spring.school.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.school.entities.School;
import com.spring.school.services.SchoolService;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SchoolController {
	
    
    private final SchoolService schoolService;

    // Create
    @PostMapping("/createNewSchool")
    public School createSchool(@RequestBody School school) {
        return schoolService.save(school);
    }

    // Read
    @GetMapping("/getSchoolById/{id}")
    public School getSchool(@PathVariable Long id) {
       return schoolService.findById(id);
    }

    // Update
    @PutMapping("/updateSchoolById/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
    	
    	return schoolService.updateSchoolById(id,school);
    }

    // PATCH operation
    @PatchMapping("/patchUpdateSchoolById/{id}")
    public School patchSchool(@PathVariable Long id, @RequestBody School school) {
        
        return schoolService.updateSchoolPartial(id,school);
    }

    // Delete
    @DeleteMapping("/deleteSchoolById/{id}")
    public String deleteSchool(@PathVariable Long id) {
        schoolService.deleteById(id);
		return "School Deleted Successfully";
    }

    // Native query 1
    @GetMapping("/name/{name}")
    public School getBySchoolName(@PathVariable String name) {
        return schoolService.findBySchoolNameNative(name);
    }

    // Native query 2
    @GetMapping("/count")
    public int countSchools() {
        return schoolService.countAllSchools();
    }

}

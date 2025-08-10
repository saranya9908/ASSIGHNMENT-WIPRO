package com.spring.school.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.school.entities.School;
import com.spring.school.repo.SchoolRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService{
	
	
	private final SchoolRepo schoolRepo;

	@Override
	public School save(School school) {
		return schoolRepo.save(school);
	}

	@Override
	public School findById(Long id) {
		return schoolRepo.findById(id).get();
               // .orElseThrow(() -> new RuntimeException("School with ID " + id + " not found")); ;
	}

	@Override
	public School findBySchoolNameNative(String name) {
		return schoolRepo.findBySchoolNameNative(name);
	}

	

	@Override
	public int countAllSchools() {
		return schoolRepo.countAllSchools();
	}

	@Override
	public School updateSchoolPartial(Long id, School school) {
		School existing = schoolRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("School with ID " + id + " not found"));

        if (school.getSchoolName() != null) {
            existing.setSchoolName(school.getSchoolName());
        }
        if (school.getSchoolAddress() != null) {
            existing.setSchoolAddress(school.getSchoolAddress());
        }
        if (school.getTeachers() != null) {
            existing.setTeachers(school.getTeachers());
        }

        return schoolRepo.save(existing);
	}

	@Override
	public School updateSchoolById(Long id, School school) {
		School existing = schoolRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("School with ID " + id + " not found"));

        existing.setSchoolName(school.getSchoolName());
        existing.setSchoolAddress(school.getSchoolAddress());
        existing.setTeachers(school.getTeachers());

        return schoolRepo.save(existing);
  }

	@Override
	public String deleteById(Long id) {
		schoolRepo.deleteById(id);
		return null;
	}

}

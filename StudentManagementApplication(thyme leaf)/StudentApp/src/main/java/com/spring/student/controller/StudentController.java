package com.spring.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.student.entities.Student;
import com.spring.student.service.StudentService;



@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String viewHome(Model model) {
		
		model.addAttribute("list",studentService.getAll());
		model.addAttribute("student",new Student());
		return "index";
	}
	
	// Show Add Student form page
	@GetMapping("/add")
	public String showAddForm(Model model) {
	    model.addAttribute("student", new Student());
	    return "add";  // corresponds to add.html
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		
		studentService.save(student);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable Integer id,Model model) {
		
		Student student=studentService.getById(id);
		model.addAttribute("student",student);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student student) {
		
		studentService.save(student);;
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		
		studentService.delete(id);;
		return "redirect:/";
	}
	


}

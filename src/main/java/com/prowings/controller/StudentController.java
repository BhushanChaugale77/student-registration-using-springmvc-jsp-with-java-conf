package com.prowings.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.dao.StudentDao;
import com.prowings.entity.Student;

@RestController
//@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentDao studentDao;
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/students")
	public ResponseEntity<String> saveStudent(@RequestBody Student student)
	{
		System.out.println("request received to save the student to DB!!");
		System.out.println("Incoming student object : "+student);
		boolean res = studentDao.saveStudent(student);
		if (res)
			return new ResponseEntity<String>("Student saved successfully!!!", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Error while saving the Student!!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/students")
	public String getStudentsList(Model model)
	{
		System.out.println("inside getStudentList() method of StudentController!!");
		List<Student> stdList = studentDao.getStudentsList();
		System.out.println(stdList);
		
		model.addAttribute("students", stdList);
		
		return "listStudent";
	}
	
	
	
}

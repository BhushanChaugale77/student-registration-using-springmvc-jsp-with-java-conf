package com.prowings.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prowings.dao.StudentDao;
import com.prowings.entity.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentDao studentDao;
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@PostMapping("/save")
	public String addStudent(HttpServletRequest model)
	{
		System.out.println("inside addStudent() in StudentController!!!!");
		String name = model.getParameter("name");
		String address = model.getParameter("address");
		
		Student student = new Student(name, address);
		
		System.out.println("incoming student model : "+student);
		
		//call to DAO logic to save incoming student
		studentDao.saveStudent(student);
		
		
		return "savedSuccess";
	}

	@GetMapping("/list")
	public String getStudentsList(Model model)
	{
		System.out.println("inside getStudentList() method of StudentController!!");
		List<Student> stdList = studentDao.getStudentsList();
		System.out.println(stdList);
		
		model.addAttribute("students", stdList);
		
		return "listStudent";
	}
	
	
	
}

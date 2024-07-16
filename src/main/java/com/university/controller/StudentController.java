package com.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.dto.ResponseStructure;
import com.university.dto.Student;
import com.university.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	public StudentService studentService;
	
	@PostMapping("/add")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student){
		return studentService.saveStudent(student);
	}
	@PutMapping("/uppdate")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student){
		return studentService.updateStudent(student);
	}
	@GetMapping("/get")
	public ResponseEntity<ResponseStructure<Student>> findStudent(@RequestParam String name){
		return studentService.findStudent(name);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@RequestParam String name){
		return studentService.deleteStudent(name);
	}

}

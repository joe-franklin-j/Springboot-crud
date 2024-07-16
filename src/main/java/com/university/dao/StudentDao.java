package com.university.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.university.dto.Student;
import com.university.repo.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
    StudentRepository studentRepository;
	
public Student saveStudent(Student student ) {
	return studentRepository.save(student);
	
}
public Student updateStudent(Student student) {
	return studentRepository.save(student);
	
}
public Optional<Student> findStudent(String name) {
	return studentRepository.findByName(name);
	}

public void deleteStudent(String name){
	studentRepository.deleteByName(name);
	
}
}

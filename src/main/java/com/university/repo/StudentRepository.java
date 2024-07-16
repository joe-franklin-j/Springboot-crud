package com.university.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.university.dto.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Optional<Student> findByName(String name);

	@Transactional
	void deleteByName(String name) ;
	 
	
}

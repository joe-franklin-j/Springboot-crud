package com.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.university.dto.Branch;
import com.university.dto.ResponseStructure;
import com.university.dto.Student;
import com.university.service.BranchService;

@RestController
public class BranchController {
	@Autowired
 BranchService branchService;
	
	@PostMapping("/addbranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @RequestParam String student_name ){
		return branchService.saveBranch(branch, student_name);
	}
	
	
	@DeleteMapping("/deletebranch")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@RequestParam String sec){
		return branchService.deleteBranch(sec);
	}
}

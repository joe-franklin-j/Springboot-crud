package com.university.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.university.dao.StudentDao;
import com.university.dto.ResponseStructure;
import com.university.dto.Student;
import com.university.exception.IdNotFoundException;
@Service
public class StudentService {
	@Autowired
 StudentDao studentDao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student){
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		studentDao.saveStudent(student);
		responseStructure.setCode(HttpStatus.CREATED.value());
		responseStructure.setData(student);
		responseStructure.setMessage("Student details saved succesfully");
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.CREATED);	
	}
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student){
		ResponseStructure<Student> responseStructure=new ResponseStructure<Student>();
		studentDao.updateStudent(student);
		responseStructure.setCode(HttpStatus.ACCEPTED.value());
		responseStructure.setData(student);
		responseStructure.setMessage("Student details updated succesfully");
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<Student>> findStudent(String name){
		ResponseStructure<Student>responseStructure=new ResponseStructure<>();
		Optional<Student> opt=studentDao.findStudent(name);
		if(opt.isEmpty()) {
		throw new IdNotFoundException();	
		}
		else {
			responseStructure.setCode(HttpStatus.FOUND.value());
			responseStructure.setData(opt.get());
			responseStructure.setMessage("Student has found");
		}
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);
		
	}
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(String name){
		ResponseStructure< Student> responseStructure =new ResponseStructure<>();
		try {
			studentDao.deleteStudent(name);
			responseStructure.setCode(HttpStatus.OK.value());
			responseStructure.setData(null);
			responseStructure.setMessage("Student account has been deleted succesfully");
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			responseStructure.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseStructure.setData(null);
			responseStructure.setMessage("Faild to delete Student account ");
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

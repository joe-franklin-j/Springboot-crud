package com.university.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.university.dao.BranchDao;
import com.university.dao.StudentDao;
import com.university.dto.Branch;
import com.university.dto.ResponseStructure;
import com.university.dto.Student;

@Service
public class BranchService {
    @Autowired
	BranchDao branchDao;
	@Autowired
	StudentDao studentDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, String student_name ){
		ResponseStructure<Branch> responseStructure = new ResponseStructure<>();
		Optional<Student> opt=studentDao.findStudent(student_name);
		if(!opt.isEmpty()) {
			Student student=opt.get();
		//	student.getBranch().add(branch);
			branch.setStudent(student);
			branchDao.saveBranch(branch);
			responseStructure.setCode(HttpStatus.CREATED.value());
			responseStructure.setData(branch);
			responseStructure.setMessage("branch saved succefully");
		}
			else {
				responseStructure.setCode(HttpStatus.NOT_FOUND.value());
				responseStructure.setData(null);
				responseStructure.setMessage("Student id not found");
		}
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);

	}
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(String sec){
		ResponseStructure<Branch> responseStructure=new ResponseStructure<>();
		try {
			branchDao.deleteBranch(sec);;
			responseStructure.setCode(HttpStatus.OK.value());
			responseStructure.setData(null);
			responseStructure.setMessage("Student account has been deleted succesfully");
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			responseStructure.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			responseStructure.setData(null);
			responseStructure.setMessage("Faild to delete Student account ");
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

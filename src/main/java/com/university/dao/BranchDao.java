package com.university.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.university.dto.Branch;
import com.university.repo.BranchRepository;
@Repository
public class BranchDao {
	@Autowired
	BranchRepository branchRepository;
	
public Branch saveBranch(Branch branch) {
	return branchRepository.save(branch);
	
}
public Branch updateBranch(Branch branch) {
	return branchRepository.save(branch);
	
}
public Optional<Branch> findBranch(int id) {
	return branchRepository.findById(id);
}
public void deleteBranch(String sec) {
	branchRepository.deleteBySec(sec);;
}
}

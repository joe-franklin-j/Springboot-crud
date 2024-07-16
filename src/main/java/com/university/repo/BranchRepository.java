package com.university.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.university.dto.Branch;

import jakarta.transaction.Transactional;

public interface BranchRepository  extends JpaRepository<Branch, Integer>{

	@Transactional
	void deleteBySec(String sec);
}

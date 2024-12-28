package com.example.checker.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.checker.model.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Integer>{

	
	int deleteCandidateByNameAndStatus(String name,String status);

	Optional<Candidate> getCandidateById(int id);

	Candidate getCandidateByName(String name);
}

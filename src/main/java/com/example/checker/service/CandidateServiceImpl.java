package com.example.checker.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.checker.model.Candidate;
import com.example.checker.repo.CandidateRepo;

import jakarta.transaction.Transactional;

@Service
public class CandidateServiceImpl implements CandidateService {
	
	CandidateRepo candidateRepoObj;
	
	CandidateServiceImpl(CandidateRepo candidateRepo)
	{
		this.candidateRepoObj = candidateRepo;
	}

	@Override
	public Candidate createCandidate(Candidate candidate) {
		
		return candidateRepoObj.save(candidate);
	}

	@Override
	public Optional<Candidate> getCandidateById(int id) {
		
		return candidateRepoObj.getCandidateById(id);
	}

	@Override
	public Candidate updateCandidate(Candidate candidate) {
		return candidateRepoObj.save(candidate);
	}

	@Override
	@Transactional
	public void deleteCandidateByNameAndStatus(String name,String status) {
		  candidateRepoObj.deleteCandidateByNameAndStatus(name, status);
		
	}

}

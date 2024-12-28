package com.example.checker.service;

import java.util.Optional;

import com.example.checker.model.Candidate;

public interface CandidateService {

	public Candidate createCandidate(Candidate candidate);
	public Optional<Candidate> getCandidateById(int id);
	public Candidate updateCandidate(Candidate candidate);
	void deleteCandidateByNameAndStatus(String name, String status);
}

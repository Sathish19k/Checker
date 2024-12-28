package com.example.checker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.checker.exception.CandidateNotFoundException;
import com.example.checker.model.Candidate;
import com.example.checker.repo.CandidateRepo;
import com.example.checker.service.CandidateServiceImpl;

@RestController
public class CandidateController {
	
	
    //To inject service dependency we use constructor inject
	
	private CandidateServiceImpl candidateService;
	private CandidateRepo candidaterepo;
	
	CandidateController(CandidateServiceImpl candidateService, CandidateRepo candidaterepo)
	{
		this.candidateService = candidateService;
		this.candidaterepo = candidaterepo;
	}
	
	@GetMapping("/candidate/{id}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable int id)
	{
		Optional<Candidate> candidate =  candidateService.getCandidateById(id);
		
		Candidate obj = candidate.orElseThrow(() -> new CandidateNotFoundException("Candidate not found for " + id));
		
		return ResponseEntity.ok(obj);
		
		
	}
	
	@PatchMapping("/candidate/update")
	public Candidate updateCandidateById(@RequestBody Candidate candidate)
	{
		return candidateService.updateCandidate(candidate);
	}
	
	@PostMapping("/candidate")
	public Candidate createCandidate(@RequestBody Candidate candidateObj)
	{
		return candidateService.createCandidate(candidateObj);
	}
	
	@DeleteMapping("/candidate/delete")
	public void deleteCandidateById(@RequestParam String name, @RequestParam String status)
	{
		  candidateService.deleteCandidateByNameAndStatus(name, status);
	}
	
	@GetMapping("/candidate/all")
	public List<Candidate> getList()
	{
		return candidaterepo.findAll();
	}
   	

}

package com.example.checker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.checker.model.Candidate;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	   @ExceptionHandler(CandidateNotFoundException.class)
	   ResponseEntity<String> CandidateNotFoundException(CandidateNotFoundException e)
	   {
		   return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST); 
	   }
	   
//	      @ExceptionHandler(CandidateNotFoundException.class)
//		  @ResponseStatus(HttpStatus.NOT_FOUND)
//		  String CandidateNotFoundException(CandidateNotFoundException e) {
//		    return e.getMessage();
//		  }
}

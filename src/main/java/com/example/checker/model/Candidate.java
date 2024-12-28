package com.example.checker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	String name;
	String status;
	
	
	Candidate()
	{
		
	}
	
	Candidate(int id, String name, String status)
	{
		this.id = id;
		this.name = name;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
	
	
	
}

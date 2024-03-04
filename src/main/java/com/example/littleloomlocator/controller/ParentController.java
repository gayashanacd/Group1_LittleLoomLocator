package com.example.littleloomlocator.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.littleloomlocator.model.ChildRepository;
import com.example.littleloomlocator.model.Parent;
import com.example.littleloomlocator.model.ParentRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ParentController {
	
	@Autowired
	ParentRepository parentRepository;
	
	@Autowired
	ChildRepository childRepository;
	
	// To get a course
	@GetMapping("/parents/{id}")
	public ResponseEntity<Parent> getParentById(@PathVariable("id") long id) {
		Optional<Parent> parentData = parentRepository.findById(id);

		if (parentData.isPresent()) {
			return new ResponseEntity<>(parentData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

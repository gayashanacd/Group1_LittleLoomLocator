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

import com.example.littleloomlocator.model.Child;
import com.example.littleloomlocator.model.ChildRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ChildController {
	
	@Autowired
	ChildRepository childRepository;
	
	// To get a course
	@GetMapping("/children/{id}")
	public ResponseEntity<Child> getChildById(@PathVariable("id") long id) {
		Optional<Child> childData = childRepository.findById(id);

		if (childData.isPresent()) {
			return new ResponseEntity<>(childData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

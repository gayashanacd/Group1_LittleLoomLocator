package com.example.littleloomlocator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.littleloomlocator.model.Child;
import com.example.littleloomlocator.model.ChildRepository;
import com.example.littleloomlocator.model.Parent;

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
	
	@GetMapping("/children")
	public ResponseEntity<List<Child>> getAllChildren(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName) {

		try {
			List<Child> children = new ArrayList<Child>();
			if (firstName == null && lastName == null) {
				childRepository.findAll().forEach(children::add);
			} else if (firstName != null && lastName != null) {
				childRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName)
						.forEach(children::add);
			} else if (firstName != null) {
				childRepository.findByFirstNameContainingIgnoreCase(firstName).forEach(children::add);
			} else if (lastName != null) {
				childRepository.findByLastNameContainingIgnoreCase(lastName).forEach(children::add);
			}

			return new ResponseEntity<>(children, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

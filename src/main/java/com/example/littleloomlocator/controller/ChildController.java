package com.example.littleloomlocator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/children")
	public ResponseEntity<Child> createChild(@RequestBody Child child) {
		try {
			Child _child = childRepository.save(new Child(child.getFirstName(), child.getLastName(), 
					child.getGender(), child.getDateOfBirth(), child.getAllergy(), child.getParent()));
			return new ResponseEntity<>(_child, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/children/{id}")
	public ResponseEntity<Child> updateChild(@PathVariable("id") long id, @RequestBody Child child) {
		Optional<Child> childData = childRepository.findById(id);

		if (childData.isPresent()) {
			Child _child = childData.get();
			_child.setFirstName(child.getFirstName());
			_child.setLastName(child.getLastName());
			_child.setGender(child.getGender());
			_child.setDateOfBirth(child.getDateOfBirth());
			_child.setAllergy(child.getAllergy());
			_child.setParent(child.getParent());
			return new ResponseEntity<>(childRepository.save(_child), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/children/{id}")
	public ResponseEntity<HttpStatus> deleteChild(@PathVariable("id") long id) {
		try {
			childRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

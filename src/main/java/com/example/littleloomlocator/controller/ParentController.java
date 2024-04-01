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
import com.example.littleloomlocator.model.Parent;
import com.example.littleloomlocator.model.ParentRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ParentController {
	
	@Autowired
	ParentRepository parentRepository;
		
	@GetMapping("/parents/{id}")
	public ResponseEntity<Parent> getParentById(@PathVariable("id") long id) {
		Optional<Parent> parentData = parentRepository.findById(id);

		if (parentData.isPresent()) {
			return new ResponseEntity<>(parentData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/parents")
	public ResponseEntity<List<Parent>> getAllParents(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName) {

		try {
			List<Parent> parents = new ArrayList<Parent>();
			if (firstName == null && lastName == null) {
				parentRepository.findAll().forEach(parents::add);
			} else if (firstName != null && lastName != null) {
				parentRepository.findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName)
						.forEach(parents::add);
			} else if (firstName != null) {
				parentRepository.findByFirstNameContainingIgnoreCase(firstName).forEach(parents::add);
			} else if (lastName != null) {
				parentRepository.findByLastNameContainingIgnoreCase(lastName).forEach(parents::add);
			} 
			
			return new ResponseEntity<>(parents, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//Get the children of a parent
	@GetMapping("/parents/{id}/children")
	public ResponseEntity<List<Child>> getParentChildren(@PathVariable("id") long id) {

		try {
			List<Child> children = new ArrayList<Child>();
			Optional<Parent> parentData = parentRepository.findById(id);

			if (parentData.isPresent()) {
				parentData.get().getChildren().forEach(children::add);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(children, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping("/parents")
	public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
		try {
			Parent _parent = parentRepository.save(new Parent(parent.getFirstName(), parent.getLastName(), 
					parent.getUnit(), parent.getBuilding(), parent.getStreet(), parent.getCity(), 
					parent.getProvince(), parent.getPostalCode(), parent.getPhone(), parent.getEmail(), 
					parent.getEmergencyContactName(), parent.getEmergencyContactPhone(), parent.getUserId()));
			return new ResponseEntity<>(_parent, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/parents/{id}")
	public ResponseEntity<Parent> updateParent(@PathVariable("id") long id, @RequestBody Parent parent) {
		Optional<Parent> parentData = parentRepository.findById(id);

		if (parentData.isPresent()) {
			Parent _parent = parentData.get();
			_parent.setFirstName(parent.getFirstName());
			_parent.setLastName(parent.getLastName());
			_parent.setUnit(parent.getUnit());
			_parent.setBuilding(parent.getBuilding());
			_parent.setStreet(parent.getStreet());
			_parent.setCity(parent.getCity());
			_parent.setProvince(parent.getProvince());
			_parent.setPostalCode(parent.getPostalCode());
			_parent.setPhone(parent.getPhone());
			_parent.setEmail(parent.getEmail());
			_parent.setEmergencyContactName(parent.getEmergencyContactName());
			_parent.setEmergencyContactPhone(parent.getEmergencyContactPhone());
			return new ResponseEntity<>(parentRepository.save(_parent), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/parents/{id}")
	public ResponseEntity<HttpStatus> deleteParent(@PathVariable("id") long id) {
		try {
			parentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

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

import com.example.littleloomlocator.model.Institute;
import com.example.littleloomlocator.model.InstituteRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InstituteController {
	
	@Autowired
	InstituteRepository instituteRepo;
	
	// To delete an institutes
	@DeleteMapping("/institutes/{id}")
	public ResponseEntity<HttpStatus> deleteInstituteById(@PathVariable long id){
		try {
			instituteRepo.deleteById(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// To delete all institutes
	@DeleteMapping("/institutes")
	public ResponseEntity<HttpStatus> deleteAllInstitutes(){
		try {
			instituteRepo.deleteAll();
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// To update an institute
	@PutMapping("/institutes/{id}")
	public ResponseEntity<Institute> updateInstituteById(@PathVariable long id, @RequestBody Institute institute){
		try {
			Optional<Institute> institute1 = instituteRepo.findById(id);
			
			if(institute1.isPresent()) {
				
				Institute institute2 = institute1.get();
				
				institute2.setName(institute.getName());
				institute2.setStreetNumber(institute.getStreetNumber());
				institute2.setStreetName(institute.getStreetName());
				institute2.setCity(institute.getCity());
				institute2.setProvince(institute.getProvince());
				institute2.setPostalCode(institute.getPostalCode());
				institute2.setContactName(institute.getContactName());
				institute2.setContactPhone(institute.getContactPhone());
				institute2.setWebSite(institute.getWebSite());
				institute2.setEmail(institute.getEmail());
				
				instituteRepo.save(institute2);
				return new ResponseEntity<>(institute2, HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// To create a new institute
	@PostMapping("/institutes")
	public ResponseEntity<Institute> createInstitute(@RequestBody Institute institute){
		try {
			Institute _institute = new Institute(institute.getName(), institute.getStreetNumber(), institute.getStreetName(), institute.getCity(), institute.getProvince(),
					institute.getPostalCode(), institute.getContactName(), institute.getContactPhone(), institute.getWebSite(),
					institute.getEmail());
			
			instituteRepo.save(_institute);
			
			return new ResponseEntity<>(_institute, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// To get an institute
	@GetMapping("/institutes/{id}")
	public ResponseEntity<Institute> getInstituteById(@PathVariable long id){
		try {
			Optional<Institute> institute = instituteRepo.findById(id);
			
			if(institute.isPresent()) {
				
				return new ResponseEntity<>(institute.get(), HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// To get all institutes
	@GetMapping("/institutes")
	public ResponseEntity<List<Institute>> getAllInstitutes(@RequestParam(required = false) String name, String city){
		try {
			List<Institute> institutes = new ArrayList<Institute>();
			
			if(name == null && city == null) {
				instituteRepo.findAll().forEach(institutes::add);
			}
			else if(name != null && city != null) {
				instituteRepo.findByNameContainingIgnoreCaseAndCityContainingIgnoreCase(name, city).forEach(institutes::add);
			}
			else if(name != null) {
				instituteRepo.findByNameContainingIgnoreCase(name).forEach(institutes::add);
			}
			else if(city != null) {
				instituteRepo.findByCityContainingIgnoreCase(city).forEach(institutes::add);
			}
			
			if(institutes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(institutes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

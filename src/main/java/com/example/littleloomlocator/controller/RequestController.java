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

import com.example.littleloomlocator.model.*;
import com.example.littleloomlocator.util.RegistrationType;
import com.example.littleloomlocator.util.RequestStatus;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RequestController {
	
	@Autowired
	RequestRepositroy requestRepositroy;
	
	// To get all requests, supporting search with parentId, instituteId, type
	@GetMapping("/requests")
	public ResponseEntity<List<Request>> getAllRequests(@RequestParam(required = false) Long parentId, @RequestParam(required = false) Long instituteId, 
			@RequestParam(required = false) RegistrationType type, @RequestParam(required = false) RequestStatus status, @RequestParam(required = false) String parentName) {	
		try {
			List<Request> requests = new ArrayList<Request>();
			if (parentId == null && instituteId == null && type == null && parentName == null && status == null) {
				requestRepositroy.findAll().forEach(requests::add);
			} else if (parentId != null && instituteId != null && type != null) {
				requestRepositroy.findByParentIdAndInstituteIdAndType(parentId, instituteId, type).forEach(requests::add);
			} else if (parentId == null && instituteId != null && type != null) {
				requestRepositroy.findByInstituteIdAndType(instituteId, type).forEach(requests::add);
			} else if (parentId == null && instituteId == null && type != null) {
				requestRepositroy.findByType(type).forEach(requests::add);
			} else if (parentId == null && instituteId != null && type == null) {
				requestRepositroy.findByInstituteId(instituteId).forEach(requests::add);
			} else if (parentId != null && instituteId == null && type == null) {
				requestRepositroy.findByParentId(parentId).forEach(requests::add);
			} else if (status != null) {
				requestRepositroy.findByStatus(status).forEach(requests::add);
			} else if (parentName != null) {
				requestRepositroy.findByParentName(parentName).forEach(requests::add);
			} 
			return new ResponseEntity<>(requests, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// To get a request
	@GetMapping("/requests/{id}")
	public ResponseEntity<Request> getRequestById(@PathVariable("id") long id) {
		Optional<Request> requestData = requestRepositroy.findById(id);
		if (requestData.isPresent()) {
			return new ResponseEntity<>(requestData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// To create a new request
	@PostMapping("/requests")
	public ResponseEntity<Request> createRequest(@RequestBody Request request) {
		try {
			Request _request = requestRepositroy.save(
					new Request(request.getParentId(), 
						request.getParentName(),
						request.getInstituteId(),
						request.getInstituteName(),
						request.getProgramName(),
						request.getChildId(), 
						request.getChildName(),
						request.getAgeGroup(), 
						request.getType(), 
						request.getStatus(),
						request.getMessage()
					));
			return new ResponseEntity<>(_request, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// To update an request
	@PutMapping("/requests/{id}")
	public ResponseEntity<Request> updateRequest(@PathVariable("id") long id, @RequestBody Request request) {
		Optional<Request> requestData = requestRepositroy.findById(id);
		if (requestData.isPresent()) {
			Request _request = requestData.get();
			_request.setParentId(request.getParentId());
			_request.setParentName(request.getParentName());
			_request.setInstituteId(request.getInstituteId());
			_request.setInstituteName(request.getInstituteName());
			_request.setProgramName(request.getProgramName());
			_request.setChildId(request.getChildId());
			_request.setChildName(request.getChildName());
			_request.setAgeGroup(request.getAgeGroup());
			_request.setType(request.getType());
			_request.setStatus(request.getStatus());
			return new ResponseEntity<>(requestRepositroy.save(_request), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// To delete a request
	@DeleteMapping("/requests/{id}")
	public ResponseEntity<HttpStatus> deleteRequest(@PathVariable("id") long id) {
		try {
			requestRepositroy.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// To delete all requests
	@DeleteMapping("/requests")
	public ResponseEntity<HttpStatus> deleteAllRequests() {
		try {
			requestRepositroy.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

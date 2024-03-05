package com.example.littleloomlocator.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "requests")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "parentId")
	private String parentId;
	
	@Column(name = "instituteId")
	private String instituteId;
	
	@Column(name = "childId")
	private String childId;
	
	@Column(name = "ageGroup")
	private String ageGroup;
	
	// TO DO - Move types in to a ENUM
	// Accepted types : ENROLMENT, WAITLIST
	@Column(name = "type")
	private String type;
		
	// TO DO - Move status in to a ENUM
	// Accepted types : PENDING, CONFIRMED, REJECTED
	@Column(name = "status")
	private String status;
	
	@Column(name = "createdDateTime")
	private LocalDateTime createdDateTime;
	
	public Request() {}
	
	public Request(String parentId, String instituteId, String childId, String ageGroup, String type, String status) {
		super();
		this.parentId = parentId;
		this.instituteId = instituteId;
		this.childId = childId;
		this.ageGroup = ageGroup;
		this.type = type;
		this.status = status;
		this.createdDateTime = LocalDateTime.now();
	}

	public String getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

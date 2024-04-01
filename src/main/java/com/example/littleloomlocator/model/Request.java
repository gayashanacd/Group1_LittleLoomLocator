package com.example.littleloomlocator.model;

import java.time.LocalDateTime;

import com.example.littleloomlocator.util.ChildAgeGroup;
import com.example.littleloomlocator.util.RegistrationType;
import com.example.littleloomlocator.util.RequestStatus;

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
	private long parentId;
	
	@Column(name = "parentName")
	private String parentName;
	
	@Column(name = "instituteId")
	private long instituteId;
	
	@Column(name = "instituteName")
	private String instituteName;
	
	@Column(name = "programName")
	private String programName;
	
	@Column(name = "childId")
	private long childId;
	
	@Column(name = "childName")
	private String childName;
	
	@Column(name = "ageGroup")
	private ChildAgeGroup ageGroup;
	
	@Column(name = "type")
	private RegistrationType type;
		
	@Column(name = "status")
	private RequestStatus status;
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@Column(name = "createdDateTime")
	private LocalDateTime createdDateTime;
	
	@Column(name = "message")
	private String message;
	
	public Request() {}
	
	public Request(long parentId, String parentName, long instituteId, String instituteName, String programName, long childId, String childName, 
			ChildAgeGroup ageGroup, RegistrationType type, RequestStatus status, String message) {
		this.parentId = parentId;
		this.parentName = parentName;
		this.instituteId = instituteId;
		this.instituteName = instituteName;
		this.programName = programName;
		this.childId = childId;
		this.childName = childName;
		this.ageGroup = ageGroup;
		this.type = type;
		this.status = status;
		this.createdDateTime = LocalDateTime.now();
		this.message = message;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(long instituteId) {
		this.instituteId = instituteId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getChildId() {
		return childId;
	}

	public void setChildId(long childId) {
		this.childId = childId;
	}

	public ChildAgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(ChildAgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public RegistrationType getType() {
		return type;
	}

	public void setType(RegistrationType type) {
		this.type = type;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}
}

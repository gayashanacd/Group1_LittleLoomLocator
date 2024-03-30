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
	
	@Column(name = "instituteId")
	private long instituteId;
	
	@Column(name = "childId")
	private long childId;
	
	@Column(name = "ageGroup")
	private ChildAgeGroup ageGroup;
	
	@Column(name = "type")
	private RegistrationType type;
		
	@Column(name = "status")
	private RequestStatus status;
	
	@Column(name = "createdDateTime")
	private LocalDateTime createdDateTime;
	
	public Request() {}
	
	public Request(long parentId, long instituteId, long childId, ChildAgeGroup ageGroup, RegistrationType type, RequestStatus status) {
		this.parentId = parentId;
		this.instituteId = instituteId;
		this.childId = childId;
		this.ageGroup = ageGroup;
		this.type = type;
		this.status = status;
		this.createdDateTime = LocalDateTime.now();
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

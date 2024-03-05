package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepositroy extends JpaRepository<Request, Long>{
	
	List<Request> findByParentId(String parentId);
	
	List<Request> findByInstituteId(String instituteId);
	
	List<Request> findByParentIdAndInstituteIdAndType(String parentId, String instituteId, String type);
	
	List<Request> findByType(String type);
}

package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepositroy extends JpaRepository<Request, Long>{
	
	List<Request> findByParentId(long parentId);
	
	List<Request> findByInstituteId(long instituteId);
	
	List<Request> findByParentIdAndInstituteIdAndType(long parentId, long instituteId, String type);
	
	List<Request> findByType(String type);
}

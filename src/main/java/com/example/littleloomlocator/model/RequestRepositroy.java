package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.littleloomlocator.util.RegistrationType;

public interface RequestRepositroy extends JpaRepository<Request, Long>{
	
	List<Request> findByParentId(long parentId);
	
	List<Request> findByInstituteId(long instituteId);
	
	List<Request> findByInstituteIdAndType(long instituteId, RegistrationType type);
	
	List<Request> findByParentIdAndInstituteIdAndType(long parentId, long instituteId, RegistrationType type);
	
	List<Request> findByType(RegistrationType type);
}

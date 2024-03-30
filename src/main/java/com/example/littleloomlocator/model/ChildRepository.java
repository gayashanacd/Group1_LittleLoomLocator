package com.example.littleloomlocator.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ChildRepository extends JpaRepository<Child, Long> {
	
	List<Child> findByLastName(String lastName);
	
	List<Child> findByLastNameContainingIgnoreCase(String lastName);
	
	List<Child> findByFirstName(String firstName);
	
	List<Child> findByFirstNameContainingIgnoreCase(String firstName);
	
	List<Child> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String title, String code);
	
	List<Child> findByParentId(long parentId);
}

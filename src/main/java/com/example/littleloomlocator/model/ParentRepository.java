package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ParentRepository extends JpaRepository<Parent, Long> {

	List<Parent> findByLastName(String lastName);
	
	List<Parent> findByFirstName(String firstName);
	
	List<Parent> findByEmail(String email);
	
}

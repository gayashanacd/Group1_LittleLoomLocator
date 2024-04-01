package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ParentRepository extends JpaRepository<Parent, Long> {

	List<Parent> findByLastName(String lastName);
	
	List<Parent> findByLastNameContainingIgnoreCase(String lastName);
	
	List<Parent> findByFirstName(String firstName);
	
	List<Parent> findByFirstNameContainingIgnoreCase(String firstName);
	
	List<Parent> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String title, String code);
	
	List<Parent> findByEmail(String email);
	
	List<Parent> findByUserId(long userId);
}

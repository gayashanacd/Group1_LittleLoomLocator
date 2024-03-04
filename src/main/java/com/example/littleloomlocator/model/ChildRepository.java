package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
	
	List<Parent> findByLastName(String lastName);
	
	List<Parent> findByFirstName(String firstName);
	
}

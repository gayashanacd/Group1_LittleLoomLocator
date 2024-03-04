package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByUsername(String username);
	
	List<User> findByType(String type);
	
}

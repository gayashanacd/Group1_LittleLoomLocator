package com.example.littleloomlocator.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.littleloomlocator.util.UserType;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	
	List<User> findByType(UserType type);
	
}

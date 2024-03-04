package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
	
	List<Institute> findByNameContainingIgnoreCase(String name);
	List<Institute> findByCityContainingIgnoreCase(String city);
	List<Institute> findByNameContainingIgnoreCaseAndCityContainingIgnoreCase(String name, String city);
	
}

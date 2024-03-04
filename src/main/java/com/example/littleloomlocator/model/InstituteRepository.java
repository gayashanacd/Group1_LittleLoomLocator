package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
	
	List<Institute> findByName(String name);
	List<Institute> findByCity(String city);
	
}

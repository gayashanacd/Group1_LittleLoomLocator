package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.littleloomlocator.util.ChildAgeGroup;

public interface InstituteRepository extends JpaRepository<Institute, Long> {
	
	List<Institute> findByNameContainingIgnoreCase(String name);
	List<Institute> findByCityContainingIgnoreCase(String city);
	List<Institute> findByNameContainingIgnoreCaseAndCityContainingIgnoreCase(String name, String city);
	
	List<Institute> findByProvinceContainingIgnoreCase(String province);
	//List<Institute> findByAgeGroupContainingIgnoreCase(ChildAgeGroup ageGroup);
	List<Institute> findByWaitlistingAllowedContainingIgnoreCase(String waitlistingAllowed);
	
}

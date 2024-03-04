package com.example.littleloomlocator;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.littleloomlocator.model.Institute;
import com.example.littleloomlocator.model.InstituteRepository;

@SpringBootApplication
public class Group1LittleLoomLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group1LittleLoomLocatorApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(InstituteRepository instituteRepo) {
		
		return args -> {
			
			instituteRepo.save(new Institute("Riverside Childcare NW", "140-1110", "Ewen Ave", "New Westminster", "BC",
					"V3M 5E4", "Paul Barby", "604-354-1180", "https://riversidechildcare.ca/",
					"riversideccnw@gmail.com"));
			
			instituteRepo.save(new Institute("Nana Licensed Daycare", "518 E", "59th Ave", "Vancouver", "BC",
					"V5X 1Y3", "Nana Wilson", "604-367-5728", "https://nana-licensed-daycare.business.site/",
					"nanadaycare@gmail.com"));
			
			instituteRepo.save(new Institute("Sing & Smile Child Care", "12057", "82 Ave", "Surrey", "BC",
					"V3W 3E1", "Karen Beach", "778-591-5999", "http://www.singandsmilechildcare.com/",
					"singandsmile@gmail.com"));
			
		};
	}
}

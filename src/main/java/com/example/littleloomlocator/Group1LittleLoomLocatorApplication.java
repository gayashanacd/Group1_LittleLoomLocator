package com.example.littleloomlocator;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.littleloomlocator.model.Institute;
import com.example.littleloomlocator.model.InstituteRepository;

import com.example.littleloomlocator.model.Child;
import com.example.littleloomlocator.model.ChildRepository;
import com.example.littleloomlocator.model.Parent;
import com.example.littleloomlocator.model.ParentRepository;


@SpringBootApplication
public class Group1LittleLoomLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group1LittleLoomLocatorApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ParentRepository parentRepository, ChildRepository childRepository, InstituteRepository instituteRepo) {
		return args -> {
			loadData(parentRepository, childRepository, instituteRepo);
		};
	}
	
	private void loadData(ParentRepository parentRepository, ChildRepository childRepository, InstituteRepository instituteRepo) {
		ArrayList<Parent> parents = new ArrayList<>();
		parentRepository.save(new Parent("Sujeewa", "Fernando","Sapperton", "6726678180", "sujeewau@hotmail.com", "Sujeewa", "6726678180"));
		parentRepository.save(new Parent("Namesh", "Chathura","New westminster", "2369963996", "nameshm89@gmail.com", "Namesh", "2369963996"));
		parentRepository.save(new Parent("Indika", "Gayashan","New westminster", "7788825994", "gayazhanmit@yahoo.com", "Indika", "7788825994"));
		
/*
		courses.get(0).addSection(new Section(1));
		courses.get(0).addSection(new Section(2));
		courses.get(1).addSection(new Section(1));
		courses.get(1).addSection(new Section(2));
		courses.get(1).addSection(new Section(3));
		courses.get(1).addSection(new Section(4));
		courses.get(2).addSection(new Section(1));
*/
		//parentRepository.saveAll(parents);

		/*
		 * Optional<Course> course = courseRepository.findByIdEagerly(1L);
		 * System.out.println(course.get().getSections());
		 */ 

		ArrayList<Child> children = new ArrayList<>();
		childRepository.save(new Child("Child1 FN", "Child 1 LN",'F',LocalDate.of(2020, 2, 16), "No"));
		childRepository.save(new Child("Child2 FN", "Child 2 LN",'F',LocalDate.of(2015, 6, 20), "No"));

		//childRepository.saveAll(children);
		
/*
		Section sec = (Section) (courses.get(0).getSections()).toArray()[0];
		Student st = students.get(0);
		Registration reg = new Registration(st, sec);
		regRepository.save(reg);

		sec = (Section) (courses.get(0).getSections()).toArray()[1];
		st = students.get(0);
		reg = new Registration(st, sec);
		regRepository.save(reg);

		sec = (Section) (courses.get(0).getSections()).toArray()[0];
		st = students.get(1);
		reg = new Registration(st, sec);
		regRepository.save(reg);*/
		
		// Adding Institutes
		
		instituteRepo.save(new Institute("Riverside Childcare NW", "140-1110", "Ewen Ave", "New Westminster", "BC",
				"V3M 5E4", "Paul Barby", "604-354-1180", "https://riversidechildcare.ca/",
				"riversideccnw@gmail.com"));
		
		instituteRepo.save(new Institute("Nana Licensed Daycare", "518 E", "59th Ave", "Vancouver", "BC",
				"V5X 1Y3", "Nana Wilson", "604-367-5728", "https://nana-licensed-daycare.business.site/",
				"nanadaycare@gmail.com"));
		
		instituteRepo.save(new Institute("Sing & Smile Child Care", "12057", "82 Ave", "Surrey", "BC",
				"V3W 3E1", "Karen Beach", "778-591-5999", "http://www.singandsmilechildcare.com/",
				"singandsmile@gmail.com"));

	}
}

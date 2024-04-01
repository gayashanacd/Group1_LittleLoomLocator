package com.example.littleloomlocator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.littleloomlocator.model.Child;
import com.example.littleloomlocator.model.ChildRepository;
import com.example.littleloomlocator.model.Institute;
import com.example.littleloomlocator.model.InstituteRepository;
import com.example.littleloomlocator.model.Notification;
import com.example.littleloomlocator.model.NotificationRepository;
import com.example.littleloomlocator.model.Parent;
import com.example.littleloomlocator.model.ParentRepository;
import com.example.littleloomlocator.model.Request;
import com.example.littleloomlocator.model.RequestRepositroy;
import com.example.littleloomlocator.model.User;
import com.example.littleloomlocator.model.UserRepository;
import com.example.littleloomlocator.util.ChildAgeGroup;
import com.example.littleloomlocator.util.RegistrationType;
import com.example.littleloomlocator.util.RequestStatus;
import com.example.littleloomlocator.util.UserType;

@SpringBootApplication
public class Group1LittleLoomLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group1LittleLoomLocatorApplication.class, args);
	}

	@Bean
	ApplicationRunner init(
			ParentRepository parentRepository, 
			ChildRepository childRepository, 
			InstituteRepository instituteRepo, 
			UserRepository userRepository, 
			NotificationRepository notificationRepository,
			RequestRepositroy requestRepositroy) {
		return args -> {
			loadData(parentRepository, childRepository, instituteRepo, userRepository, notificationRepository, requestRepositroy);
		};
	}
	
	private void loadData(ParentRepository parentRepository, 
			ChildRepository childRepository, 
			InstituteRepository instituteRepo, 
			UserRepository userRepository, 
			NotificationRepository notificationRepository,
			RequestRepositroy requestRepositroy) {
		
		// create parents 
		ArrayList<Parent> parents = new ArrayList<>();
		parents.add(new Parent("Sujeewa", "Fernando", "1200", "320", "Sherbrooke Street", "New Westminster", "BC", "V3L3M6", "6726678180", "sujeewau@hotmail.com", "Sujeewa", "6726678180", 2));
		parents.add(new Parent("Namesh", "Chathura", "1201", "321", "Street1", "New Westminster", "BC", "V3L3M6", "2369963996", "nameshm89@gmail.com", "Namesh", "2369963996", 4));
		parents.add(new Parent("Indika", "Gayashan", "1202", "322", "Street2", "New Westminster", "BC", "V3L3M6", "7788825994", "gayazhanmit@yahoo.com", "Indika", "7788825994", 1));
		
		// add children to parents
		parents.get(0).addChild(new Child("Senuli", "Fernando",'F',LocalDate.of(2020, 2, 16), "No"));
		parents.get(1).addChild(new Child("Menuli", "Chathura",'F',LocalDate.of(2015, 6, 20), "No"));
		parents.get(1).addChild(new Child("Sandani", "Chathura",'F',LocalDate.of(2018, 9, 10), "No"));
		parentRepository.saveAll(parents);
		
		// Adding Institutes
		instituteRepo.save(new Institute("Riverside Childcare NW", "140-1110", "" ,"Ewen Ave", "New Westminster", "BC",
				"V3M 5E4", "Paul Barby", "604-354-1180", "https://riversidechildcare.ca/",
				"riversideccnw@gmail.com", "Infant", ChildAgeGroup.valueOf("UNDER_36_MONTHS"), 20, "Yes", 5, 3));
		
		instituteRepo.save(new Institute("Nana Licensed Daycare", "518 E", "" ,"59th Ave", "Vancouver", "BC",
				"V5X 1Y3", "Nana Wilson", "604-367-5728", "https://nana-licensed-daycare.business.site/",
				"nanadaycare@gmail.com", "Preschool", ChildAgeGroup.valueOf("BETWEEN_3_5_YEARS"), 50, "Yes", 10, 3));
		
		instituteRepo.save(new Institute("Sing & Smile Child Care", "12057", "" ,"82 Ave", "Surrey", "BC",
				"V3W 3E1", "Karen Beach", "778-591-5999", "http://www.singandsmilechildcare.com/",
				"singandsmile@gmail.com", "Preschool", ChildAgeGroup.valueOf("BETWEEN_3_5_YEARS"), 30, "No", 0, 4));
		
		// Adding users 
		ArrayList<User> users = new ArrayList<>();
		users.add(new User("admin", "admin", UserType.valueOf("ADMIN")));
		users.add(new User("parent", "parent", UserType.valueOf("PARENT")));
		users.add(new User("institute", "institute", UserType.valueOf("INSTITUTE")));
		users.add(new User("parent2", "parent2", UserType.valueOf("PARENT")));
		userRepository.saveAll(users);
		
		// Adding notifications
		notificationRepository.save(new Notification(3, "Sing & Smile Child Care", 2, "Sujeewa", "Your application is accepted.", false));
		notificationRepository.save(new Notification(5, "Nana Licensed Daycare", 4, "Namesh", "Your application is still in waitlist. We will share an update once you receive a seat.", false));
		notificationRepository.save(new Notification(6, "Riverside Childcare NW", 2, "Sujeewa", "We are in the process of accomodating seats for the requested children.", false));
		
		// Adding requests
		ArrayList<Request> requests = new ArrayList<>();
		requests.add(new Request(1, "Sujeewa Fernando", 1, "Riverside Childcare NW", "Infant", 1, "Senuli Fernando", ChildAgeGroup.valueOf("UNDER_36_MONTHS"), 
				RegistrationType.valueOf("ENROLMENT"), RequestStatus.valueOf("PENDING"), "Test message 1"));
		requests.add(new Request(2, "Namesh Chathura", 2, "Nana Licensed Daycare", "Preschool", 2, "Menuli Chathura", ChildAgeGroup.valueOf("BETWEEN_3_5_YEARS"), 
				RegistrationType.valueOf("ENROLMENT"), RequestStatus.valueOf("PENDING"), "Test message 2"));
		requests.add(new Request(1, "Sujeewa Fernando", 3, "Sing & Smile Child Care", "Infant", 1, "Senuli Fernando", ChildAgeGroup.valueOf("BETWEEN_3_5_YEARS"), 
				RegistrationType.valueOf("WAITLIST"), RequestStatus.valueOf("PENDING"), "Test message 3"));
		requests.add(new Request(2, "Namesh Chathura", 3, "Sing & Smile Child Care", "Infant", 2, "Menuli Chathura", ChildAgeGroup.valueOf("BETWEEN_3_5_YEARS"), 
				RegistrationType.valueOf("ENROLMENT"), RequestStatus.valueOf("PENDING"), "Test message 4"));
		requestRepositroy. saveAll(requests);
	}
}

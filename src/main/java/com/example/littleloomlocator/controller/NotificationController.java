package com.example.littleloomlocator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.littleloomlocator.model.Notification;
import com.example.littleloomlocator.model.NotificationRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class NotificationController {

	@Autowired
	NotificationRepository notificationRepository;

	@GetMapping("/notifications")
	public ResponseEntity<List<Notification>> getAllNotifications() {

		try {
			List<Notification> notifications = new ArrayList<Notification>();

			notificationRepository.findAll().forEach(notifications::add);

			if (notifications.isEmpty()) {
				return new ResponseEntity<>(notifications, HttpStatus.NO_CONTENT);

			}
			return new ResponseEntity<>(notifications, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/notifications")
	public ResponseEntity<Notification> createNotification(@RequestBody Notification notification){
		
		try {
			Notification _notification = notificationRepository.save(new Notification(notification.getSenderId(),
					notification.getSenderName(),notification.getReceiverId(),notification.getReceiveName(),notification.getMessage(),notification.isRead()));
		return new ResponseEntity<>(_notification,HttpStatus.CREATED);
		
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	

}

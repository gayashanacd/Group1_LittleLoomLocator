package com.example.littleloomlocator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.littleloomlocator.model.Notification;
import com.example.littleloomlocator.model.NotificationRepository;
import com.example.littleloomlocator.model.Request;
import com.example.littleloomlocator.util.RegistrationType;
import com.example.littleloomlocator.util.RequestStatus;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class NotificationController {

	@Autowired
	NotificationRepository notificationRepository;

	@GetMapping("/notifications")
	public ResponseEntity<List<Notification>> getAllNotifications(@RequestParam(required = false) Long receiverId) {
		try {
			List<Notification> notifications = new ArrayList<Notification>();
			if (receiverId == null) {
				notificationRepository.findAll().forEach(notifications::add);
			} else if(receiverId != null){
				notificationRepository.findByReceiverId(receiverId).forEach(notifications::add);
			}
			if (notifications.isEmpty()) {
				return new ResponseEntity<>(notifications, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(notifications, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/notifications")
	public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
		try {
			Notification _notification = notificationRepository.save(new Notification(notification.getSenderId(),
					notification.getSenderName(), notification.getReceiverId(), notification.getReceiveName(),
					notification.getMessage(), notification.isRead()));
			return new ResponseEntity<>(_notification, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchMapping("/notifications/{id}")
	public ResponseEntity<Notification> patchNotification(@PathVariable("id") long id,
			@RequestBody Notification notification) {
		Optional<Notification> notificationData = notificationRepository.findById(id);

		if (notificationData.isPresent()) {
			Notification _notification = notificationData.get();
			_notification.setMessage("Your application is accepted");

			return new ResponseEntity<>(notificationRepository.save(_notification), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

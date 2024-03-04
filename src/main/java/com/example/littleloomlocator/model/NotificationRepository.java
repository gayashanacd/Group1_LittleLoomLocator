package com.example.littleloomlocator.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	List<Notification> findBySenderId(int senderId);

	List<Notification> findByReceiverId(int receiverId);

	//List<Notification> findByRead(boolean read);
}

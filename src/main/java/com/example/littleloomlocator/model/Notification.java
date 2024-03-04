package com.example.littleloomlocator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "senderId")
	private int senderId;

	@Column(name = "senderName")
	private String senderName;

	@Column(name = "receiverId")
	private int receiverId;

	@Column(name = "receiveName")
	private String receiveName;

	@Column(name = "message")
	private String message;

	@Column(name = "status")
	private boolean isRead;

	public Notification() {

	}

	public Notification(int senderId, String senderName, int receiverId, String receiveName, String message,
			boolean isRead) {
		this.senderId = senderId;
		this.senderName = senderName;
		this.receiverId = receiverId;
		this.receiveName = receiveName;
		this.message = message;
		this.isRead = isRead;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

}

package com.example.littleloomlocator.model;

import java.time.LocalDateTime;
import com.example.littleloomlocator.util.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "type")
	private UserType type;
	
	@Column(name = "createdDateTime")
	private LocalDateTime createdDateTime;
	
	public User() {}
	
	public User(String username, String password, UserType type) {
		this.username = username;
		this.password = password;
		this.type = type;
		this.createdDateTime = LocalDateTime.now();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
}

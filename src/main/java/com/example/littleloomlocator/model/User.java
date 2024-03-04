package com.example.littleloomlocator.model;

import jakarta.persistence.*;


@Entity
@Table(name = "courses")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	

}

package com.example.demo.Entity;

import javax.management.relation.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class User {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(unique = true, nullable = false)
	 private String email;
	 
	 private String name;
	 private String password;
	 
	 @Enumerated(EnumType.STRING) 
	    private UserRole role;  // ADMIN, MANAGER, DEVELOPER, TESTER
	}


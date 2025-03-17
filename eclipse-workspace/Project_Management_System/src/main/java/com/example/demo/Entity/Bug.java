package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bugs")

public class Bug {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String title;
	 private String description;
	 
	 @Enumerated(EnumType.STRING)
	 private BugSeverity severity; // LOW, MEDIUM, HIGH, CRITICAL
	 
	 @Enumerated(EnumType.STRING)
	 private BugStatus status; // OPEN, IN_PROGRESS, FIXED, CLOSED
	 
	 
	 @ManyToOne
	 private Task task;
	 
	 @ManyToOne
	 private User reportedBy;
	 
	 @ManyToOne
	 private User assignedTo;
	

}

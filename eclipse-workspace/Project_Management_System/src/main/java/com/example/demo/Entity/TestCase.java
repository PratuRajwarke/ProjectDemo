package com.example.demo.Entity;

import javax.management.relation.Role;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test_cases")

public class TestCase {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String title;
	 private String steps;
	 private String expectedResult;
	
	 
	 @Enumerated(EnumType.STRING)
	 private TestCaseStatus status; // PASSED, FAILED, PENDING
	 
	 
	 @ManyToOne
	 private Task task;
	 @ManyToOne
	 private User tester;

}

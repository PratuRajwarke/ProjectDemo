package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "projects")

public class Project {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 private String description;
	 
	 @ManyToOne
	 private User manager;
	 
	// @OneToMany(mappedBy = "project")
	 //private List<Task> tasks;
	
	 @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<Task> tasks = new ArrayList<>();


	    // Constructor
	    public Project(String name) {
	        this.name = name;
	    }

}



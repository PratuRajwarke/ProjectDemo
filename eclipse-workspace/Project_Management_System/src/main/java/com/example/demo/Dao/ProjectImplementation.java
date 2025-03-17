package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Project;
import com.example.demo.Repository.ProjectRepository;
import com.example.demo.Service.ProjectService;

@Service
public class ProjectImplementation implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public Project SaveProjects(Project project) {
		
		return projectRepository.save(project);
	}

	@Override
	public List<Project> getProjects() {
		
		return projectRepository.findAll();
	}

}

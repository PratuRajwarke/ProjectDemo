package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.Project;

public interface ProjectService {
	
	Project SaveProjects(Project project);
	
	List<Project> getProjects();


}

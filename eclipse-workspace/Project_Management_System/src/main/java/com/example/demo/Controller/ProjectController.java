package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Dao.ProjectImplementation;
import com.example.demo.Entity.Project;

@RestController
@RequestMapping("/api/Produts")

public class ProjectController {
	
	@Autowired
	ProjectImplementation projectImplementation;
	
	 // Save projects
    @PostMapping("/Create")
    public ResponseEntity<Project> saveUser(@RequestBody Project project) {
    	Project AddProject = projectImplementation.SaveProjects(project);
        return ResponseEntity.ok(AddProject);
    }

    // Get All projects
    @GetMapping("/list")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectImplementation.getProjects();
        return ResponseEntity.ok(projects);
    }

}

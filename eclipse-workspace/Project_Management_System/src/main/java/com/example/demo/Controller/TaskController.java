package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Emp;
import com.example.demo.Dao.TaskImplementation;
import com.example.demo.Entity.Task;

@RestController
@RequestMapping("/api/Tasks")

public class TaskController {
	
	@Autowired
	TaskImplementation taskImplementation;
	
	 // Save Task
    @PostMapping("/")
    public ResponseEntity<Task> saveUser(@RequestBody Task task) {
    	Task AddProject = taskImplementation.SaveTask(task);
        return ResponseEntity.ok(AddProject);
    }

    // get Tasks
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllEmployees() {
        List<Task> projects = taskImplementation.getTasks();
        return ResponseEntity.ok(projects);
    }
    
 // Update Status by ID
    @PutMapping("/{id}/Status")
    public ResponseEntity<Task> updateEmployee(@PathVariable long id, @RequestBody Task task) {
        Optional<Task> existingEmpOptional = taskImplementation.getById(id);

        if (!existingEmpOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Task existingTask = existingEmpOptional.get();
        existingTask.setStatus(task.getStatus());
       

        Task updatedTask = taskImplementation.SaveTask(existingTask);
        return ResponseEntity.ok(updatedTask);
    }


}

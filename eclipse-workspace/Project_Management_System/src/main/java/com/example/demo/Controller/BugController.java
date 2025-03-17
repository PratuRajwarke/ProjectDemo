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


import com.example.demo.Dao.BugImplementation;
import com.example.demo.Entity.Bug;


@RestController
@RequestMapping("/api/bugs")
public class BugController {
	
	@Autowired
	BugImplementation bugImplementation;
	
	 // Save bugs
    @PostMapping("/Report")
    public ResponseEntity<Bug> saveUser(@RequestBody Bug bug) {
    	Bug savebugs = bugImplementation.SaveBug(bug);
        return ResponseEntity.ok(savebugs);
    }

    // Get All bugs
    @GetMapping("/")
    public ResponseEntity<List<Bug>> getAllEmployees() {
        List<Bug> bugs = bugImplementation.getBugs();
        return ResponseEntity.ok(bugs);
    }
    
 // Update Employee by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Bug> updateBug(@PathVariable long id, @RequestBody Bug bug) {
        Optional<Bug> existingBugOptional = bugImplementation.getById(id);

        if (!existingBugOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Bug existingBug = existingBugOptional.get();
        existingBug.setStatus(bug.getStatus()); // Fixed method call

        Bug updatedBug = bugImplementation.SaveBug(existingBug);
        return ResponseEntity.ok(updatedBug);
    }


}

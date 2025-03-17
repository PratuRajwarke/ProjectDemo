package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.UserImplementation;
import com.example.demo.Entity.User;

@RestController
@RequestMapping("/api/users")

public class UserController {
	
	@Autowired
	UserImplementation userImplementation;
	
	 // Save Employee
    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
    	User registerUser = userImplementation.SaveUser(user);
        return ResponseEntity.ok(registerUser);
    }

    // Get All Employees
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllEmployees() {
        List<User> users = userImplementation.getUsers();
        return ResponseEntity.ok(users);
    }

}

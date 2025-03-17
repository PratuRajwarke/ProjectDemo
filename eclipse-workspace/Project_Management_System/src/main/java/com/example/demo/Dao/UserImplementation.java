package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

@Service
public class UserImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User SaveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		
		return userRepository.findAll();
	}

}

package com.example.demo.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Task;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Service.TaskService;

@Service
public class TaskImplementation implements TaskService {
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public Task SaveTask(Task task) {
		
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getTasks() {
		
		return taskRepository.findAll();
	}

	@Override
	public Optional<Task> getById(long id) {
		
		return taskRepository.findById(id);
	}

	
	

}

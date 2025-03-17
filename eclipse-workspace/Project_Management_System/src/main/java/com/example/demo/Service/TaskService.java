package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Emp;
import com.example.demo.Entity.Task;

public interface TaskService {

	Task SaveTask(Task task);
	
	List<Task> getTasks();
	
	Optional<Task> getById(long id);
}

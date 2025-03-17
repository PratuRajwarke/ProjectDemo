package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import com.example.demo.Entity.Bug;


public interface BugService {
	
	Bug SaveBug(Bug bug);
	
	List<Bug> getBugs();
	
	Optional<Bug> getById(long id);

}

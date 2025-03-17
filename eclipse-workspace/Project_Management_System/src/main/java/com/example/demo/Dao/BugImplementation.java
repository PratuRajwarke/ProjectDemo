package com.example.demo.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Bug;
import com.example.demo.Repository.BugRepository;
import com.example.demo.Service.BugService;

@Service
public class BugImplementation implements BugService{

	@Autowired
	BugRepository BugRepository;
	
	@Override
	public Bug SaveBug(Bug bug) {
		
		return BugRepository.save(bug);
	}

	@Override
	public List<Bug> getBugs() {
		
		return BugRepository.findAll();
	}

	@Override
	public Optional<Bug> getById(long id) {
		
		return BugRepository.findById(id);
	}

}

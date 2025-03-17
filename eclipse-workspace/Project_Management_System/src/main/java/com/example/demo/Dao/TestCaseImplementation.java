package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.TestCase;
import com.example.demo.Repository.TestCaseRepository;
import com.example.demo.Service.TestCaseService;

@Service
public class TestCaseImplementation implements TestCaseService{
	
	@Autowired
	TestCaseRepository testCaseRepository;

	@Override
	public TestCase SaveTestCase(TestCase testCase) {
		
		return testCaseRepository.save(testCase);
	}

	@Override
	public List<TestCase> getTestCases() {
		
		return testCaseRepository.findAll();
	}

	

}

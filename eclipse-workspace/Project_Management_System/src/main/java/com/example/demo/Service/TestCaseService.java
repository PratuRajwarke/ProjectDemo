package com.example.demo.Service;

import java.util.List;
import com.example.demo.Entity.TestCase;


public interface TestCaseService {
	
	TestCase SaveTestCase(TestCase testCase);
	
	List<TestCase> getTestCases();

}

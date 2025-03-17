package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.TestCaseImplementation;
import com.example.demo.Entity.TestCase;

@RestController
@RequestMapping("/api/TestCase")
public class TestCaseController {
	
	@Autowired
	TestCaseImplementation testCaseImplementation;
	
	 // Save TestCase
    @PostMapping("/")
    public ResponseEntity<TestCase> saveUser(@RequestBody TestCase testCase) {
    	TestCase AddTestCases = testCaseImplementation.SaveTestCase(testCase);
        return ResponseEntity.ok(AddTestCases);
    }

    // get all TestCases
    @GetMapping("/")
    public ResponseEntity<List<TestCase>> getAllEmployees() {
        List<TestCase> TestCases = testCaseImplementation.getTestCases();
        return ResponseEntity.ok(TestCases);
    }

}

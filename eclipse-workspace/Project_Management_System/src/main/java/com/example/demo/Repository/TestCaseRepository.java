package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Task;
import com.example.demo.Entity.TestCase;

@Repository

public interface TestCaseRepository extends JpaRepository<TestCase, Long>{

}

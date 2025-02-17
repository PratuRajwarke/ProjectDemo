package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Integer> {

    // Find the minimum salary
    @Query("SELECT MIN(e.salary) FROM Emp e")
    Float findMinSalary();

    // Find the maximum salary
    @Query("SELECT MAX(e.salary) FROM Emp e")
    Float findMaxSalary();

    // Finds the second highest salary
    @Query("SELECT MAX(e.salary) FROM Emp e WHERE e.salary < (SELECT MAX(e2.salary) FROM Emp e2)")
    Float findSecondHighestSalary();

    // Retrieve Employees Sorted by Salary in Descending Order
    List<Emp> findAllByOrderBySalaryDesc();
}

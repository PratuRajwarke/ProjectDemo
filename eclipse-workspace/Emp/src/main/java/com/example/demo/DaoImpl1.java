package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaoImpl1 implements EmpService {

    @Autowired
    private EmpRepo empRepo;

    @Override
    public Emp saveData(Emp emp) {
        return empRepo.save(emp);
    }

    @Override
    public List<Emp> getData() {
        return empRepo.findAll();
    }

    @Override
    public void deleteData(int id) {
        empRepo.deleteById(id);
    }

    @Override
    public Optional<Emp> getById(int id) {
        return empRepo.findById(id);
    }

    // Get Minimum Salary
    public Float getMinSalary() {
        return empRepo.findMinSalary();
    }

    // Get Maximum Salary
    public Float getMaxSalary() {
        return empRepo.findMaxSalary();
    }

    // Get Second Highest Salary
    public Float getSecondHighestSalary() {
        return empRepo.findSecondHighestSalary();
    }

    // Get Employee with Second Last Salary
    public Emp getSecondLastSalaryEmployee() {
        List<Emp> employees = empRepo.findAllByOrderBySalaryDesc();
        if (employees.size()<2) {
        	return null;
        }
        return employees.get(1);
    }
}

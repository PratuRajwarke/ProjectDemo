package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class controllerEmp {

    @Autowired
    private DaoImpl1 empDao;

    // Save Employee
    @PostMapping("/save")
    public ResponseEntity<Emp> saveEmployee(@RequestBody Emp emp) {
        Emp savedEmployee = empDao.saveData(emp);
        return ResponseEntity.ok(savedEmployee);
    }

    // Get All Employees
    @GetMapping("/list")
    public ResponseEntity<List<Emp>> getAllEmployees() {
        List<Emp> employees = empDao.getData();
        return ResponseEntity.ok(employees);
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Emp>> getEmployeeById(@PathVariable int id) {
        Optional<Emp> employee = empDao.getById(id);
        return employee.isPresent() ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    // Update Employee by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Emp> updateEmployee(@PathVariable int id, @RequestBody Emp empDetails) {
        Optional<Emp> existingEmpOptional = empDao.getById(id);

        if (!existingEmpOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Emp existingEmp = existingEmpOptional.get();
        existingEmp.setName(empDetails.getName());
        existingEmp.setEmail(empDetails.getEmail());
        existingEmp.setAddress(empDetails.getAddress());
        existingEmp.setDepartment(empDetails.getDepartment());
        existingEmp.setSalary(empDetails.getSalary());

        Emp updatedEmp = empDao.saveData(existingEmp);
        return ResponseEntity.ok(updatedEmp);
    }

    // Delete Employee by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        empDao.deleteData(id);
        return ResponseEntity.noContent().build();
    }

    // Get Minimum Salary
    @GetMapping("/min-salary")
    public ResponseEntity<Float> getMinSalary() {
        Float minSalary = empDao.getMinSalary();
        return ResponseEntity.ok(minSalary);
    }

    // Get Maximum Salary
    @GetMapping("/max-salary")
    public ResponseEntity<Float> getMaxSalary() {
        Float maxSalary = empDao.getMaxSalary();
        return ResponseEntity.ok(maxSalary);
    }

    // Get Second Highest Salary
    @GetMapping("/second-highest-salary")
    public ResponseEntity<Float> getSecondHighestSalary() {
        Float secondHighestSalary = empDao.getSecondHighestSalary();
        return ResponseEntity.ok(secondHighestSalary);
    }

    // Get Employee with Second Last Salary
    @GetMapping("/second-last-salary")
    public Emp getSecondLastSalaryEmployee() {
        return empDao.getSecondLastSalaryEmployee();
    }
}

package org.example.springexample.controller;

import org.example.springexample.models.Employee;
import org.example.springexample.repository.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        Employee employeeServiceById = employeeService.getById(id);
        return (employeeServiceById != null) ? ResponseEntity.ok(employeeServiceById) : ResponseEntity.notFound().build();
    }
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee createEmployee = employeeService.create(employee);
        return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.update(employee);
        return (updateEmployee != null) ? ResponseEntity.ok(updateEmployee) : ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.notFound().build();
    }
}
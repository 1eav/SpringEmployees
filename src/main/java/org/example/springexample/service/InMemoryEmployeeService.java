package org.example.springexample.service;

import org.example.springexample.models.Employee;
import org.example.springexample.repository.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InMemoryEmployeeService implements EmployeeService {
    private final ConcurrentHashMap<Long, Employee> employeeMap = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    @Override
    public Employee getById(Long id) {
        return employeeMap.get(id);
    }
    @Override
    public List<Employee> getAll() {
        return employeeMap.values().stream().toList();
    }
    @Override
    public Employee create(Employee employee) {
        Long id = idGenerator.getAndIncrement();
        employee.setId(id);
        employeeMap.put(id, employee);
        System.out.println("Create ID");
        return employee;
    }
    @Override
    public Employee update(Employee employee) {
        Long id = employee.getId();
        if (employeeMap.contains(id)) {
            employeeMap.put(id, employee);
            System.out.println("Update by ID:" + id);
            return employee;
        }
        return null;
    }
    @Override
    public void deleteById(Long id) {
        System.out.println("Delete by ID: " + id);
        employeeMap.remove(id);
    }
}
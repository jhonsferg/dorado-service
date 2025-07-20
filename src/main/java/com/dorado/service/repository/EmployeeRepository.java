package com.dorado.service.repository;

import com.dorado.service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeRepository {
    private final Map<Long, Employee> employees = new HashMap<>();
    private Long nextId = 1L;

    public EmployeeRepository() {
        save(new Employee(1L, "DYLAN PIZARRO", "CAJERO", "913458756", 1L, 0.5));
        save(new Employee(2L, "EMILIANO QUINTANILLA", "MOZO", "946578412", 1L, 0.5));
        save(new Employee(3L, "SANTIAGO PRIETO", "COCINERO", "999458766", 1L, 0.5));
        save(new Employee(4L, "JOSÉ SANTILLÁN", "GERENTE", "923456621", 1L, 0.5));
    }

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(nextId++);
        }
        return employees.put(employee.getId(), employee);
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(employees.get(id));
    }

    public void deleteById(Long id) {
        employees.remove(id);
    }
}

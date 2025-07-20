package com.dorado.service.controller;

import com.dorado.service.model.Employee;
import com.dorado.service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getALLSales() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getSaleById(@PathVariable Long id) {
        return this.employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Employee updateSale(@PathVariable Long id, @RequestBody Employee employee) {
        return this.employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        this.employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}

package com.example.keycloaktest.controller;

import com.example.keycloaktest.entity.Employee;
import com.example.keycloaktest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    @RolesAllowed("user")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    //this method can be accessed by user whose role is admin
    @GetMapping
    @RolesAllowed("admin")
    public ResponseEntity<List<Employee>> findALlEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

}

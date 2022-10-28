package com.example.keycloaktest.service;

import com.example.keycloaktest.entity.Employee;
import com.example.keycloaktest.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void saveEmployee(){
        employeeRepository.saveAll(
                Stream.of(
                        new Employee("hope",22.0),
                        new Employee( "mary", 70.0),
                        new Employee( "peter", 38.0)
                ).collect(Collectors.toList()));
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


}

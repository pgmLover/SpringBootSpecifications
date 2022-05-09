package com.example.SpringSpecification.controller;

import com.example.SpringSpecification.entity.Employee;
import com.example.SpringSpecification.service.EmployeeServices;
import com.example.SpringSpecification.specifications.EmployeeSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeServices.addEmployee(employee);
    }

    @GetMapping("/employees")
    public Page<Employee> getEmployeesByLastName(Pageable pageable, EmployeeSpecifications employeeSpecifications){
        return employeeServices.findAll(pageable, employeeSpecifications);
    }
}

package com.example.SpringSpecification.controller;

import com.example.SpringSpecification.entity.Employee;
import com.example.SpringSpecification.service.EmployeeServices;
import com.example.SpringSpecification.specifications.EmployeeSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeServices.findAll();
    }

//    @GetMapping("/employees/{age}/{firstName}")
//    public List<Employee> getEmployeesByAgeAndFirstNAme(@RequestParam int age,@RequestParam String firstName){
//        Specification<Employee> specifications=Specification.where(EmployeeSpecifications.hasAgeRequest(age).and(EmployeeSpecifications.likeFirstName(firstName)));
//        return employeeServices.findAllByAgeAndFirstName(specifications);
//    }

    @GetMapping("/employees")
    public List<Employee> getEmployeesByLastName( EmployeeSpecifications employeeSpecifications){
        return employeeServices.findAlls(employeeSpecifications);
    }
}

package com.example.SpringSpecification.service;

import com.example.SpringSpecification.entity.Employee;
import com.example.SpringSpecification.repository.UserRepository;
import com.example.SpringSpecification.specifications.EmployeeSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {


    @Autowired
    private UserRepository userRepository;

    public Employee addEmployee(Employee employee){
        return userRepository.save(employee);
    }



    public  Page findAll(Pageable pageable, EmployeeSpecifications specification){

//        Pageable paging = PageRequest.of(specification, pageSize, sort);
//        Page<Employee> pagedResult = userRepository.findAll(paging);
//        return pagedResult.toList();

        return userRepository.findAll(specification, pageable);
    }


}

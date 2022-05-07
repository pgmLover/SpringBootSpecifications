package com.example.SpringSpecification.service;

import com.example.SpringSpecification.entity.Employee;
import com.example.SpringSpecification.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public  List<Employee> findAll(){
        return userRepository.findAll();
    }

    public  List<Employee> findAlls(Specification<Employee> specification){
        return userRepository.findAll(specification);
    }

    public List<Employee>  findAllByAgeAndFirstName(Specification<Employee> specification){
        return userRepository.findAll(specification);
    }

    public List<Employee> findAllByLastName(Specification<Employee> specification){
        return userRepository.findAll(specification);
    }
}

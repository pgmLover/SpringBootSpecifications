package com.example.SpringSpecification.repository;

import com.example.SpringSpecification.entity.Employee;

import java.util.List;

public interface EmployeeCustomRepository {
List<Employee> findByFirstnameAndAge(String firstName,Long age);
}

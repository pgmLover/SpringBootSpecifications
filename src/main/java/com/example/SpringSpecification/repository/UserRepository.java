package com.example.SpringSpecification.repository;


import com.example.SpringSpecification.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<Employee, Long>,EmployeeCustomRepository,
        JpaSpecificationExecutor<Employee> {

}

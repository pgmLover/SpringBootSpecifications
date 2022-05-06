package com.example.SpringSpecification.repository;


import com.example.SpringSpecification.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee, Long>{

}

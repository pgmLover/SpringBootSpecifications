package com.example.SpringSpecification.specifications;

import com.example.SpringSpecification.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecifications {

    public static Specification<Employee> likeFirstName(String firstName){
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("firstName"),"%"+firstName+"%");
        }));
    }

    public  static  Specification<Employee> hasAgeRequest(int age){
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("age"),age);
        }));
    }

    public static Specification<Employee> likeLastName(String lastName){
        return ((root, query, criteriaBuilder) -> {
            return  criteriaBuilder.like(root.get("lastName"),"%"+lastName+"%");
        }
        );
    }
}

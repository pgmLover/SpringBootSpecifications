package com.example.SpringSpecification.specifications;

import com.example.SpringSpecification.entity.Employee;
import com.example.SpringSpecification.entity.Employee_;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeSpecifications implements Specification<Employee>{

  private String firstName;
  private String lastName;
  private String email;
  private int age;

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates=new ArrayList<>();
        if (firstName != null) {
            predicates.add(criteriaBuilder.like(root.get(Employee_.FIRST_NAME),"%d"+ firstName+"%d"));
        }

        if (lastName != null) {
            predicates.add(criteriaBuilder.like(root.get(Employee_.LAST_NAME), "%d"+lastName+"%d"));
        }

        if (email != null) {
            predicates.add(criteriaBuilder.like(root.get(Employee_.EMAIL), "%d"+email+"%d"));
        }

        if(age !=0){
            predicates.add(criteriaBuilder.equal(root.get(Employee_.AGE),age));
        }

        return  criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
//    public static Specification<Employee> likeFirstName(String firstName){
//        return (((root, query, criteriaBuilder) -> {
//            return criteriaBuilder.like(root.get("firstName"),"%"+firstName+"%");
//        }));
//    }
//
//    public  static  Specification<Employee> hasAgeRequest(int age){
//        return (((root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get("age"),age);
//        }));
//    }
//
//    public static Specification<Employee> likeLastName(String lastName){
//        return ((root, query, criteriaBuilder) -> {
//            return  criteriaBuilder.like(root.get("lastName"),"%"+lastName+"%");
//        }
//        );
//    }


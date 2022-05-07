package com.example.SpringSpecification.repository;

import com.example.SpringSpecification.entity.Employee;
import com.example.SpringSpecification.entity.Employee_;
import com.example.SpringSpecification.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {
    @Autowired
    EntityManager entityManager;
    @Override
    public List<Employee> findByFirstnameAndAge(String firstName,String lastName,int age, String email) {

        CriteriaBuilder cb= entityManager.getCriteriaBuilder();
        CriteriaQuery cq=cb.createQuery();

        Root<Employee> employee=cq.from(Employee.class);

        Predicate firstNamePredicate=cb.equal(employee.get(Employee_.FIRST_NAME),firstName);
        Predicate agePredicate=cb.equal(employee.get(Employee_.AGE),age);
        Predicate emailPredicate=cb.equal(employee.get(Employee_.email),email);
        Predicate lastNamePredicate=cb.equal(employee.get(Employee_.LAST_NAME),lastName);

        cq.where(firstNamePredicate,lastNamePredicate,emailPredicate,agePredicate);
        TypedQuery<Employee> query=entityManager.createQuery(cq);
        return query.getResultList();

    }
}

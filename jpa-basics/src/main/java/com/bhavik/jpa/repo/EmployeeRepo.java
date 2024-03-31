package com.bhavik.jpa.repo;


import com.bhavik.jpa.inh.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import  java.util.*;

@Repository
public class EmployeeRepo {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void storeEmployee(Employee employee){
        em.persist(employee);
    }


    @Transactional
    public Employee getEmployeeById(Long id){
        Employee employee = em.find(Employee.class, id);
        return  employee;
    }

    public List<Employee> getAllEmployees(){
        Query query = em.createQuery("select e from Employee e", Employee.class);
        List<Employee> employeeList = query.getResultList();
        return  employeeList;
    }


}

package com.bhavik.jpa.repo;


import com.bhavik.jpa.inh.entity.Employee;
import com.bhavik.jpa.inh.entity.FullTimeEmployee;
import com.bhavik.jpa.inh.entity.PartTimeEmployee;
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
        List<Employee> employeeList = new ArrayList<>();

        Query query = em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class);
        employeeList.addAll(query.getResultList());
        Query query1 = em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class);
        employeeList.addAll(query1.getResultList());

        return  employeeList;
    }


}

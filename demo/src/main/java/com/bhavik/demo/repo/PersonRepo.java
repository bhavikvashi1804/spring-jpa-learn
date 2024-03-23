package com.bhavik.demo.repo;

import com.bhavik.demo.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class PersonRepo {

    @PersistenceContext
    EntityManager entityManager;


    public List<Person> getAllPerson(){
        Query query = entityManager.createQuery("select p from Person p");
        return query.getResultList();
    }

    public List<Person> getPersonById(Long id){
        Person person = entityManager.find(Person.class, id);
        return Collections.singletonList(person);
    }
}

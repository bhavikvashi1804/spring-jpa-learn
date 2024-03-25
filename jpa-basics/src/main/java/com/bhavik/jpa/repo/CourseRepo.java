package com.bhavik.jpa.repo;


import com.bhavik.jpa.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import  java.util.*;

@Repository
public class CourseRepo {

    @PersistenceContext
    EntityManager entityManager;

    public Course findById(Long id){
        Course course = entityManager.find(Course.class, id);
        return  course;
    }

    public Course save(Course course){
        Course updatedCourse  = entityManager.merge(course);
        return  updatedCourse;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);
    }

    public List<Course> getAllCourse(){
        Query query = entityManager.createQuery("select c from Course c");
        List<Course> courseList = query.getResultList();
        return  courseList;
    }
}

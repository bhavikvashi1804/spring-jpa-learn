package com.bhavik.jpa.repo;


import com.bhavik.jpa.entity.Course;
import com.bhavik.jpa.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Course save(Course course){
        Course updatedCourse  = entityManager.merge(course);
        return  updatedCourse;
    }

    @Transactional
    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);
    }

    public List<Course> getAllCourse(){
        Query query = entityManager.createQuery("select c from Course c");
        List<Course> courseList = query.getResultList();
        return  courseList;
    }


    @Transactional
    public void test(){
        Course course = entityManager.find(Course.class, 1L);

        entityManager.detach(course);

        course.setName("Updated Name by Bhavik");
        entityManager.merge(course);
    }

    @Transactional
    public Course addDummyReviews(Long id){
        Course course = entityManager.find(Course.class, id);

        Review review1 = new Review("Best Course", "4");
        Review review2 = new Review("Precise Course", "4" );

        course.addReview(review1);
        course.addReview(review2);

        entityManager.persist(review1);
        entityManager.persist(review2);

        return  course;
    }
}

package com.bhavik.jpa.repo;


import com.bhavik.jpa.entity.Course;
import com.bhavik.jpa.entity.Passport;
import com.bhavik.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    @PersistenceContext
    EntityManager entityManager;

    public Student findById(Long id){
        Student student = entityManager.find(Student.class, id);
        return  student;
    }

    @Transactional
    public Student save(Student student){
        Student updatedCourse  = entityManager.merge(student);
        return  updatedCourse;
    }

    @Transactional
    public void deleteById(Long id){
        Student student = findById(id);
        entityManager.remove(student);
    }

    public List<Student> getAllStudents(){
        Query query = entityManager.createQuery("select s from Student s");
        List<Student> studentList = query.getResultList();
        return  studentList;
    }

    @Transactional
    public void saveStudentWithPassport(){
        Passport passport = new Passport("INDGJ001");
        entityManager.persist(passport);
        Student student = new Student("Smit Modi");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    @Transactional
    public void addCourse(Long studentId, Long courseId){
        Student student = entityManager.find(Student.class, studentId);
        Course course = entityManager.find(Course.class, courseId);

        student.addCourse(course);

        entityManager.persist(student);
    }

    @Transactional
    public void removeCourse(Long studentId, Long courseId){
        Student student = entityManager.find(Student.class, studentId);

        Course course = student.getCourseList().stream().filter(x -> x.getId().equals(courseId)).findFirst().orElse(null);

        if(course != null){
            student.removeCourse(course);
            entityManager.persist(student);
        }
    }

}

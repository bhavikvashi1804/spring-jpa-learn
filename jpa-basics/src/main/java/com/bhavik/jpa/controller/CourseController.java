package com.bhavik.jpa.controller;


import com.bhavik.jpa.entity.Course;
import com.bhavik.jpa.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Autowired
    CourseRepo courseRepo;

    @GetMapping()
    public List<Course> getCourseDetails(@RequestParam(required = false) Optional<Long> id){
        if(id.isPresent()){
            return Collections.singletonList(courseRepo.findById(id.get()));
        }
        else{
            return  courseRepo.getAllCourse();
        }
    }

    @DeleteMapping
    public void deleteCourseById(@RequestParam Long id){
        courseRepo.deleteById(id);
    }

    @GetMapping("/test")
    public void test(){
        courseRepo.test();
    }

    @PutMapping()
    public Course updateCourse(@RequestBody Course course){
        Course saved = courseRepo.save(course);
        return  saved;
    }

    @PostMapping()
    public Course storeCourse(@RequestBody Course course){
        Course saved = courseRepo.save(course);
        return  saved;
    }


    @PostMapping("reviews/add")
    public Course addDummyReviews(@RequestParam Long id){
        Course course = courseRepo.addDummyReviews(id);
        return  course;
    }

    @PostMapping("students/add")
    public void addStudent(@RequestParam Long courseId, @RequestParam Long studentId){
        courseRepo.addStudent(courseId, studentId);
    }

    @DeleteMapping("students/remove")
    public void removeStudent(@RequestParam Long courseId, @RequestParam Long studentId){
        courseRepo.removeStudent(courseId, studentId);
    }

}

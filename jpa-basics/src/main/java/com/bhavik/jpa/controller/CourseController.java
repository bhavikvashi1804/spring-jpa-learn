package com.bhavik.jpa.controller;


import com.bhavik.jpa.entity.Course;
import com.bhavik.jpa.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

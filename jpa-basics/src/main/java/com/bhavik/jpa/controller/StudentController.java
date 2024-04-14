package com.bhavik.jpa.controller;


import com.bhavik.jpa.entity.Student;
import com.bhavik.jpa.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping()
    public List<Student> getStudentDetails(@RequestParam(required = false) Optional<Long> id){
        if(id.isPresent()){
            return Collections.singletonList(studentRepo.findById(id.get()));
        }
        else{
            return  studentRepo.getAllStudents();
        }
    }

    @DeleteMapping
    public void deleteStudentById(@RequestParam Long id){
        studentRepo.deleteById(id);
    }



    @PutMapping()
    public Student updateStudent(@RequestBody Student student){
        Student saved = studentRepo.save(student);
        return  saved;
    }

    @PostMapping()
    public Student storeStudent(@RequestBody Student student){
        Student saved = studentRepo.save(student);
        return  saved;
    }

    @GetMapping("test")
    public void test(){
        studentRepo.saveStudentWithPassport();
    }

    @PostMapping("addCourse")
    public void addCourse(@RequestParam Long studentId, @RequestParam Long courseId){
        studentRepo.addCourse(studentId, courseId);
    }

    @DeleteMapping("removeCourse")
    public void removeCourse(@RequestParam Long studentId, @RequestParam Long courseId){
        studentRepo.removeCourse(studentId, courseId);
    }
}

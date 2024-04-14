package com.bhavik.jpa.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table( name = "student_tb_details")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private  Long id;

    @Column(name = "student_name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn( name = "passport_id")
    private Passport passport;

    @ManyToMany
    @JoinTable(
            name = "student_course_dtls",
            joinColumns = @JoinColumn( name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    List<Course> courseList = new ArrayList<>();

    public void addCourse(Course course){
        courseList.add(course);
    }

    public void removeCourse(Course course){
        courseList.remove(course);
    }

    public Student(String name){
        this.name = name;
    }
}

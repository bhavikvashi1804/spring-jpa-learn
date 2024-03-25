package com.bhavik.jpa.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "course_tb_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "course_id" )
    private Long id;

    @Column(name = "course_name")
    private String name;

    public Course(String name){
        this.name = name;
    }
}

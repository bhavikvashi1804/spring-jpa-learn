package com.bhavik.jpa.entity;


import jakarta.persistence.*;
import lombok.*;

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

    public Student(String name){
        this.name = name;
    }
}

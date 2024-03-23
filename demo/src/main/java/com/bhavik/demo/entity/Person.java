package com.bhavik.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person_tb_person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;
}

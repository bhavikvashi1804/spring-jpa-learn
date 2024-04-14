package com.bhavik.jpa.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_tb_details")
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "book_id")
    private Long id;

    @Column( name = "year_of_publish")
    private Long publishYear;

    @Column( name = "book_name")
    private String name;


    public Book(String name, Long publishYear){
        this.name = name;
        this.publishYear = publishYear;
    }


}

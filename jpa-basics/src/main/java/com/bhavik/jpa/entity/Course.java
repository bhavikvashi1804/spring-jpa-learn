package com.bhavik.jpa.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.*;

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

    @OneToMany( mappedBy = "course")
    List<Review> reviewList = new ArrayList<>();

    public Course(String name){
        this.name = name;
    }

    public void addReview(Review review){
        review.setCourse(this);
        this.reviewList.add(review);
    }

    public void removeReview(Review review){
        review.setCourse(null);
        this.reviewList.remove(review);
    }

}

package com.bhavik.jpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "review_tb_details")
@Data
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "desc")
    private String description;

    @Column(name = "rating")
    private String rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_id")
    @JsonIgnore
    Course course;

    public Review(String description, String rating){
        this.description = description;
        this.rating = rating;
    }
}

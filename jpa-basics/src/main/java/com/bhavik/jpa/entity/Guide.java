package com.bhavik.jpa.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table( name = "guide_tb_details")
@Data
@NoArgsConstructor
public class Guide {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "guide_id")
    private Long id;

    @Column( name = "guide_name")
    private String name;

    public Guide(String name){
        this.name = name;
    }

    @OneToMany( mappedBy = "guide", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Trainee> trainees = new ArrayList<>();

    public void addTrainee(Trainee trainee){
        trainee.setGuide(this);
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee){
        trainee.setGuide(null);
        trainees.remove(trainee);
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

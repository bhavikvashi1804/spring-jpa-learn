package com.bhavik.jpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "trainee_tb_details")
@Data
@NoArgsConstructor
public class Trainee {

    @Id
    @Column( name = "trainee_id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "trainee_name")
    private String name;

    @ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn( name = "guide_id")
    @JsonIgnore
    Guide guide;

    public Trainee(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

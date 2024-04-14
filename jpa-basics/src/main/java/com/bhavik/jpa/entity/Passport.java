package com.bhavik.jpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passport_tb_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "passport_id")
    private Long id;

    @Column( name = "passport_number")
    private String number;

    @OneToOne(mappedBy = "passport")
    @JsonIgnore
    Student student;

    public Passport(String number){
        this.number = number;
    }


    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}

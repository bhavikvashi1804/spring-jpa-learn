package com.bhavik.jpa.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passport_tb_details")
@Data
@NoArgsConstructor
public class Passport {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "passport_id")
    private Long id;

    @Column( name = "passport_number")
    private String number;

    public Passport(String number){
        this.number = number;
    }
}

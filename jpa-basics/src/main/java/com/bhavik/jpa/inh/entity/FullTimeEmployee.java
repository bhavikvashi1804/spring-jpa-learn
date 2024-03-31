package com.bhavik.jpa.inh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class FullTimeEmployee extends Employee{

    @Column(name = "emp_salary")
    private Long salary;

    public FullTimeEmployee(String name, Long salary){
        super(name);
        this.salary = salary;
    }
}

package com.bhavik.jpa.inh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table( name = "FULLTIME_EMP_DETAILS")
public class FullTimeEmployee extends Employee{

    @Column(name = "emp_salary")
    private Long salary;

    public FullTimeEmployee(String name, Long salary){
        super(name);
        this.salary = salary;
    }
}

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
public class PartTimeEmployee extends Employee{

    @Column( name = "emp_daily_wage")
    private Long wage;

    public PartTimeEmployee(String name, Long wage){
        super(name);
        this.wage = wage;
    }
}

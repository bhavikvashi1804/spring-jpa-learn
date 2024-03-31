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
@Table( name = "PARTTIME_EMP_DETAILS")
public class PartTimeEmployee extends Employee{

    @Column( name = "emp_daily_wage")
    private Long wage;

    public PartTimeEmployee(String name, Long wage){
        super(name);
        this.wage = wage;
    }
}

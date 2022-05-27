package com.example.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Integer id;
    
    @Column(name = "NAME")
    private String name;
    	
    @Column(name = "MONTHLY_SALARY")
    private int monthlySalary;

}

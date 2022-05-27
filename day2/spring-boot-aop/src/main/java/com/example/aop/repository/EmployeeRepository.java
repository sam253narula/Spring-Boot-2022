package com.example.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aop.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}

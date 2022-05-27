package com.example.aop.service;

import java.util.Optional;

import com.example.aop.entity.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	Optional<Employee> getEmployeeById(Integer id);
	 
	void deleteEmployeeByid(int id);

}
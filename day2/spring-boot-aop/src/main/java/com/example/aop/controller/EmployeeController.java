package com.example.aop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.entity.Employee;
import com.example.aop.service.EmployeeService;

@RestController
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public String addEmployee(Employee employee) {
		 employeeService.addEmployee(employee);
		 return "Employee Added";
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(Employee employee) {
		 employeeService.updateEmployee(employee);
		 return "Employee Updated";
	}
	
	@GetMapping("/getEmployeeById")
	public Optional<Employee> getEmployeeById(int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/deleteEmployeeByid")
	public String deleteEmployeeByid(int id) {
		 employeeService.deleteEmployeeByid(id);
		 return "Employee Deleted";
	}
}

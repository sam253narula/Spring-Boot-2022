package com.microstream.springbootcrud.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microstream.springbootcrud.example.entity.Student;
import com.microstream.springbootcrud.example.repository.StudentRepository;

@RestController
public class StudentCRUDController {

	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/storeAll")
	public String storeAll(@RequestBody ArrayList<Student> students) {
		return studentRepository.storeAll(students);
	}

	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		return studentRepository.add(student);
	}

	@GetMapping("/findAll")
	public  List<Student> findAll() {
		return studentRepository.findAll();
	}

	@GetMapping("/findByFirstName")
	public List<Student> findByFirstName(final String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	@GetMapping("/findByLastName")
	public List<Student> findByLastName(final String lastName) {
		return studentRepository.findByLastName(lastName);
	}

	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		return studentRepository.deleteAll();
	}

}

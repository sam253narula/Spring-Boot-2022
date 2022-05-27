package com.microstream.springbootcrud.example.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microstream.springbootcrud.example.entity.Student;

@Component
public interface StudentRepository {
	String add(Student student);

	List<Student> findAll();

	String storeAll(List<Student> students);

	List<Student> findByFirstName(String firstName);
	
	List<Student> findByLastName(String lastName);

	String deleteAll();

}

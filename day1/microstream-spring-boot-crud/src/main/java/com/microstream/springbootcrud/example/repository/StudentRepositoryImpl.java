
package com.microstream.springbootcrud.example.repository;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.microstream.springbootcrud.example.entity.Student;

import lombok.extern.slf4j.Slf4j;
import one.microstream.reflect.ClassLoaderProvider;
import one.microstream.storage.embedded.types.EmbeddedStorage;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;

@Slf4j
@Repository
public class StudentRepositoryImpl implements StudentRepository
{
	private final List<Student> students;
	private final EmbeddedStorageManager storage;
	
	public StudentRepositoryImpl(@Value("${microstream.store.location}") final String location)
	{
		super();
		
		this.students = new ArrayList<>();
		
//		this.storage   = EmbeddedStorage.start(
//			this.students,
//			Paths.get(location)
//		);
		// Refer for below: https://docs.microstream.one/manual/storage/customizing/custom-class-loader.html
		this.storage =  EmbeddedStorage.Foundation(Paths.get(location))
			.onConnectionFoundation(cf ->
				cf.setClassLoaderProvider(ClassLoaderProvider.New(
					Thread.currentThread().getContextClassLoader()
				))
			)
			.start(this.students);
		
	}
	
	
	@Override
	public String storeAll(List<Student> students)
	{
		log.info("Storing Students -> {}", students);
		this.students.addAll(students);
		this.storage.store(this.students);
		return "All Data Stored";
		
	}
	
	@Override
	public String add(Student student)
	{
		log.info("Storing Student -> {}", student);
		this.students.add(student);
		this.storage.store(this.students);
		
		return "Student Added Successfully";
	}
	
	@Override
	public List<Student> findAll()
	{
		return this.students;
	}
	
	@Override
	public List<Student> findByFirstName(String firstName)
	{
		return this.students.stream()
			.filter(c -> c.getFirstName().equals(firstName))
			.collect(Collectors.toList());
	}
	
	@Override
	public List<Student> findByLastName(String lastName)
	{
		return this.students.stream()
			.filter(c -> c.getLastName().equals(lastName))
			.collect(Collectors.toList());
	}
	
	@Override
	public String deleteAll()
	{
		this.students.clear();
		this.storeAll(students);
		return "All data deleted";
	}
	
}

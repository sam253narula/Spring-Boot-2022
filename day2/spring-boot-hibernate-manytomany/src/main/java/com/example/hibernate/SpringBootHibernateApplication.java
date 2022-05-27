package com.example.hibernate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Student;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootHibernateApplication implements CommandLineRunner  {
	
	@Autowired
	EntityManager entityManager;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// Uncomment all lines when we have bi-directional relationship
		// When Student is the owning side of the relationship 
		Student student = entityManager.find(Student.class, 1L);
		log.info("Fetch Student Details -> {}", student);
		log.info("Fetch Students Course Details -> {}", student.getCourses());
		
		//When Course is the owning side of the relationship
		Course course = entityManager.find(Course.class, 1L);
		log.info("Fetch Course Details -> {}", course);
		log.info("Fetch Students who have enrolled in this Course -> {}", course.getStudents());

	}

}

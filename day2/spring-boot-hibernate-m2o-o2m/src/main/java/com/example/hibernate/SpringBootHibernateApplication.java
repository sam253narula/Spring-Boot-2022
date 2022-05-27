package com.example.hibernate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hibernate.entity.Course;
import com.example.hibernate.entity.Review;

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
	//@Transactional
	public void run(String... args) throws Exception {
		
		// Default fetch type for OneToMany is Lazy
//		Course course = entityManager.find(Course.class, 1L);
//		log.info("Fetch Course Details -> {}",course );
//		log.info("Fetch review Details - > {}", course.getReviews());
		
		// Fetch Course From Review, since it is bidirectional Relationship, default fetch type for ManyToOne is eager
		Review review = entityManager.find(Review.class, 1L);
		log.info("fetch Course Details -> {}",review );
		log.info("Fetch review details - > {}", review.getCourse());
	}

}

package com.example.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private int rating;

	private String description;
	
	@ManyToOne
	private Course course;
	
}
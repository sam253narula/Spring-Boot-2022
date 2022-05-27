package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	
//	@OneToOne
//	private Passport passport;
		
	@OneToOne(fetch = FetchType.LAZY)
//	@OneToOne
	private Passport passport;

	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + "]";
//	}

//	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}


}
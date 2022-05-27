
package com.microstream.springbootcrud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student
{
	private long studentNumber;
	private String firstName;
	private String lastName;
}

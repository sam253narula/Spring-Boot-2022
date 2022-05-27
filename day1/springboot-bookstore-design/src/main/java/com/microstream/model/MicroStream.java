package com.microstream.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class MicroStream {

	private String courseName;
	private String courseType;
	private String instructorName;
//	private FullName instrutorName;
	
	public MicroStream(String courseName, String courseType, String instructorName) {
		super();
		this.courseName = courseName;
		this.courseType = courseType;
		this.instructorName = instructorName;
	}

	// All possible set of constructors


//	public MicroStream(String instructorName) {
//		this.instructorName = instructorName;
//	}

}

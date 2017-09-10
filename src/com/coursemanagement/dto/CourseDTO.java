package com.coursemanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_DTO")
public class CourseDTO {
	
	@Id
	@GeneratedValue
	@Column(name = "COURSE_ID")
	private int courseId;
	
	@Column(name = "COURSE_NAME")
	private String courseName;
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
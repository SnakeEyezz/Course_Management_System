package com.coursemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coursemanagement.dao.CourseDao;
import com.coursemanagement.dto.CourseDTO;

@Service
public class CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	@Transactional
	public void addCourse(CourseDTO course) {
		
		courseDao.addCourse(course);
	}
	
	@Transactional
	public List<CourseDTO> listCourse() {
		
		return courseDao.listCourse();
	}
	
	@Transactional
	public CourseDTO getCourseById(int courseId) {
		
		return courseDao.getCourseById(courseId);
	}

}
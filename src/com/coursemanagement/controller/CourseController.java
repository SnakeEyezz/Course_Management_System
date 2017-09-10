package com.coursemanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coursemanagement.dto.CourseDTO;
import com.coursemanagement.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "/course", method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<CourseDTO> getCourseList(){
	
	ArrayList<CourseDTO> courseList = new ArrayList<CourseDTO>();
	courseList.addAll(courseService.listCourse());
	
	return courseList;
	}
	
	@RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<CourseDTO> getCourseById(@PathVariable("courseId") int courseId){
	
	ArrayList<CourseDTO> courseList = new ArrayList<CourseDTO>();
	courseList.add(courseService.getCourseById(courseId));
	
	return courseList;
	}
	
	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public boolean addCourse(@RequestBody CourseDTO course){
	
	courseService.addCourse(course);
	
	return true;
	}

}
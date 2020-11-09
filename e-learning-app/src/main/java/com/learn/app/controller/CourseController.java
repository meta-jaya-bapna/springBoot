package com.learn.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learn.app.model.Course;
import com.learn.app.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@GetMapping(value="/courses")
	public ResponseEntity<Object> getAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		try {
			courses = courseService.getAllCourses();
		} catch(Exception e) {
			logger.error("Exception : ", e);
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}
	
	@GetMapping(value = "/course/{id}")
	public ResponseEntity<Object> getCourseDetail(@PathVariable int id) {
		Course course = null;
		try {
		    course = courseService.getCourseDetails(id);
		} catch(Exception e) {
			logger.error("Exception : ", e);
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

}

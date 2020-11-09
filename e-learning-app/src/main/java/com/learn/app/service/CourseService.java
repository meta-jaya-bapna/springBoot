package com.learn.app.service;

import java.util.List;

import com.learn.app.model.Course;

public interface CourseService {

	public List<Course> getAllCourses();

	public Course getCourseDetails(int id); 
}

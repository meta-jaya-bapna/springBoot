package com.learn.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.app.dao.CourseDao;
import com.learn.app.model.Course;
import com.learn.app.repository.CourseRepository;

@Service
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses() {
		List<Course> courses = (List<Course>)courseRepository.findAll();
		return courses;
	}
	
	public Course getCourseDetails(int id) {
	    return courseRepository.getOne(id);
    }
	
}

package com.learn.app.dao;

import java.util.List;

import com.learn.app.model.Course;

public interface CourseDao {

    /**
     * Method to get list of all courses
     * @return list of courses
     */
	public List<Course> getAllCourses();
	
	/**
	 * Method to get course details by id
	 * @param id
	 * @return
	 */
	public Course getCourseDetails(int id); 
}

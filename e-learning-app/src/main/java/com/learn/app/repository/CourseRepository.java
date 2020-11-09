package com.learn.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.app.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}

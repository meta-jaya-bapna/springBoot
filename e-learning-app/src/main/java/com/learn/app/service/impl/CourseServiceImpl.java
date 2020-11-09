package com.learn.app.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.app.dao.CourseDao;
import com.learn.app.model.Course;
import com.learn.app.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = courseDao.getAllCourses();
        return courses;
    }

    @Override
    public Course getCourseDetails(int id) {
        if (StringUtils.isNotBlank(Integer.toString(id))) {
            return courseDao.getCourseDetails(id);
        }
        return null;
    }

}

package com.learn.app.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.app.dao.UserDao;
import com.learn.app.model.Course;
import com.learn.app.model.User;
import com.learn.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createUserAccount(User user) {
        if (null != user) {
            userDao.createUserAccount(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        if (StringUtils.isNotBlank(Integer.toString(id))) {
            return userDao.getUserById(id);
        }
        return null;
    }

    @Override
    public void deleteUserAccount(int id) {
        if (StringUtils.isNotBlank(Integer.toString(id))) {
            userDao.deleteUserAccount(id);
        }
    }

    @Override
    public List<Course> getUserEnrolledCourses(int id) {
        if (StringUtils.isNotBlank(Integer.toString(id))) {
            return userDao.getUserEnrolledCourses(id);
        }
        return null;
    }

    @Override
    public void registerInCourse(int userId, int courseId) {
        if (StringUtils.isAnyBlank((Integer.toString(userId)), (Integer.toString(courseId)))) {
        userDao.registerInCourse(userId, courseId);
        }
    }

}

package com.learn.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.app.dao.UserDao;
import com.learn.app.model.Course;
import com.learn.app.model.User;
import com.learn.app.repository.CourseRepository;
import com.learn.app.repository.UserRepository;

/**
 * 
 * @author jaya
 *
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void createUserAccount(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public void deleteUserAccount(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Course> getUserEnrolledCourses(int id) {
        User user = userRepository.getOne(id);
        if (user != null) {
            return (List<Course>) user.getCourses();
        } 
        return null;
    }

    @Override
    public void registerInCourse(int userId, int courseId) {
        User user = userRepository.getOne(userId);
        if (user != null) {
           Course course = courseRepository.getOne(courseId);
           if(course != null) {
               user.setCourses(course);
           }
        }
    }

}

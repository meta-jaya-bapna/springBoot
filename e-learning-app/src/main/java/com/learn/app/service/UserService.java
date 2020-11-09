package com.learn.app.service;

import java.util.List;

import com.learn.app.model.Course;
import com.learn.app.model.User;

public interface UserService {

    /**
     * Method to create user account
     * 
     * @param user
     */
    public void createUserAccount(User user);

    /**
     * Method to get list of all users
     * 
     * @return
     */
    public List<User> getAllUsers();

    /**
     * Method to get user by id
     * 
     * @param id
     * @return
     */
    public User getUserById(int id);

    /**
     * Method to delete user by id
     * 
     * @param id
     */
    public void deleteUserAccount(int id);

    /**
     * Method to get user enrolled courses
     * 
     * @param id
     * @return
     */
    public List<Course> getUserEnrolledCourses(int id);

    /**
     * Method to register user in a course
     * 
     * @param userId
     * @param courseId
     */
    public void registerInCourse(int userId, int courseId);

}

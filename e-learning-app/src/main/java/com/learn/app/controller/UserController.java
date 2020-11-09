package com.learn.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.app.model.Course;
import com.learn.app.model.User;
import com.learn.app.model.UserCourseEntity;
import com.learn.app.service.UserService;
import com.learn.app.utils.JsonHelper;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/createUser")
    public void createUserAccount(@RequestBody String payload) {
        User user = JsonHelper.toObject(payload, User.class);
        if (null != user) {
            userService.createUserAccount(user);
        }
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Object> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            users = userService.getAllUsers();
        } catch (Exception e) {
            logger.error("Exception : ", e);
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        User user = new User();
        try {
            user = userService.getUserById(id);
        } catch (Exception e) {
            logger.error("Exception : ", e);
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserAccount(@PathVariable int id) {
        userService.deleteUserAccount(id);
    }

    @PostMapping
    public void registerInCourse(@RequestBody String payload) {
        UserCourseEntity entity = JsonHelper.toObject(payload, UserCourseEntity.class);
        try {
            userService.registerInCourse(entity.getUserId(), entity.getCourseId());
        } catch (Exception e) {
            logger.error("Exception : ", e);
        }
    }

    @GetMapping(value = "/userCourses/{id}")
    public ResponseEntity<Object> getUserEnrolledCourses(@PathVariable int id) {
        List<Course> courses = new ArrayList<Course>();
        try {
            courses = userService.getUserEnrolledCourses(id);
        } catch (Exception e) {
            logger.error("Exception : ", e);
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

}

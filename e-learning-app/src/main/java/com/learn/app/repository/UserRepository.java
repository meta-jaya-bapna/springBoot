package com.learn.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}

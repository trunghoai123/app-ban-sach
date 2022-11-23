package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
 

public class UserServiceImp implements UserService{
	
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
}

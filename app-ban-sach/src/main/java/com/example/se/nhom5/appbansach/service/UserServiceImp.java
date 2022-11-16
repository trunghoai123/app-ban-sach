package com.example.se.nhom5.appbansach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.se.nhom5.appbansach.dao.UserRepository;
import com.example.se.nhom5.appbansach.entity.User;

public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }
    
}

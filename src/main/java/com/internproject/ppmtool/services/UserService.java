package com.internproject.ppmtool.services;

import com.internproject.ppmtool.domain.User;
import com.internproject.ppmtool.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder BCryptPasswordEncoder;

    public User saveUser(User newUser) {
        newUser.setPassword(BCryptPasswordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }
}
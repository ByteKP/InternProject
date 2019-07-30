package com.internproject.ppmtool.services;

import com.internproject.ppmtool.domain.User;
import com.internproject.ppmtool.exceptions.UsernameAlreadyExistsException;
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
        try {
            newUser.setPassword(BCryptPasswordEncoder.encode(newUser.getPassword()));

            newUser.setUsername(newUser.getUsername());
            return userRepository.save(newUser);
        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username:  " + newUser.getUsername() + " already exists");
        }
    }
}
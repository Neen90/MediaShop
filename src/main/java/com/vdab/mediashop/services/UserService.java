package com.vdab.mediashop.services;

import com.vdab.mediashop.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveNewUser(User newUser) {
        userRepository.saveNewUser(newUser);
    }
}

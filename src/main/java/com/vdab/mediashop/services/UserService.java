package com.vdab.mediashop.services;

import com.vdab.mediashop.domain.Users;
import com.vdab.mediashop.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveNewUser(Users newUser) {
        userRepository.saveNewUser(newUser);
    }

    public List<Users> getUsers() {
        return userRepository.getUsers();

    }

    public Users findById(Long id) {
        return userRepository.findById(id);
    }

    public void updateLoginValue(Long id) {
        Users users = userRepository.findById(id);
        users.setLoggedIn(true);
        userRepository.updateLoginValue(users);
    }

    public void updateToLoggedOut(Long id) {
        Users users = userRepository.findById(id);
        users.setLoggedIn(false);
        userRepository.updateToLoggedOut(users);
    }
}

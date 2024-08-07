package com.springBoot.ProjectTracker.service.users_service.user_service_implementation;

import com.springBoot.ProjectTracker.model.users.User;
import com.springBoot.ProjectTracker.repository.user_repository.UserRepository;
import com.springBoot.ProjectTracker.service.users_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
//write code to save user

        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User>  searchUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> searchUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(int id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }
}

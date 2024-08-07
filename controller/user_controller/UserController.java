package com.springBoot.ProjectTracker.controller.user_controller;

import com.springBoot.ProjectTracker.dto.user_dto.UserDto;
import com.springBoot.ProjectTracker.model.users.User;
import com.springBoot.ProjectTracker.service.users_service.UserService;
import com.springBoot.ProjectTracker.utility.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired(required = true)
    private UserMapper userMapper;


    @PostMapping("/register_user")
    public User registerUser(@Valid @RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return userService.createUser(user);
//        returning in this manner exposes all the user related fields
    }

    @GetMapping("/list_all_users")
    public List<User> listAllUser() {
        log.info("incoming request- list");
        return userService.listAllUsers();
    }

    @GetMapping("/search")
    public User searchUser(@RequestParam(name = "email", required = false) String userEmail,
                           @RequestParam(name = "id", required = false) String userId,
                           @RequestParam(name = "firstname", required = false) String userFirstName,
                           @RequestParam(name = "lastname", required = false) String userLastName) {
        log.info("incoming request");
//        log.info(userEmail);

        Optional<User> searchedUser = userEmail != null && !userEmail.trim().isEmpty() ?
                userService.searchUserByEmail(userEmail.trim()) :
                (userId != null && !userId.trim().isEmpty() ?
                        userService.searchUserById(Integer.parseInt(userId.trim())) : Optional.empty());

        if (searchedUser.isEmpty()) {
            // if a user is not found by email or id
            // then allow to perform search by name

            throw new RuntimeException("not a valid user");
        }

        return searchedUser.get();

    }
}

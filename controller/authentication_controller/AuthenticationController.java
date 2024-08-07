package com.springBoot.ProjectTracker.controller.authentication_controller;

import com.springBoot.ProjectTracker.constants.RoleName;
import com.springBoot.ProjectTracker.dto.user_dto.LoginUserDto;
import com.springBoot.ProjectTracker.dto.user_dto.RegisterUserDto;
import com.springBoot.ProjectTracker.model.users.User;
import com.springBoot.ProjectTracker.response.LoginResponse;
import com.springBoot.ProjectTracker.service.authentication_service.AuthenticationService;
import com.springBoot.ProjectTracker.service.jwt_service.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        // check if role in given or not
        if (registerUserDto.getRoleName().toString().isEmpty()) {
            // assign default role
            registerUserDto.setRoleName(RoleName.USER);
        }

        User signup = authenticationService.signup(registerUserDto);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(signup);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
//        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}

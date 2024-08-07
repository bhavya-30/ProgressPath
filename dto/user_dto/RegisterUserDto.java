package com.springBoot.ProjectTracker.dto.user_dto;

import com.springBoot.ProjectTracker.constants.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserDto {
    private String email;
    private String password;
    private String fullName;
    private RoleName roleName;
}

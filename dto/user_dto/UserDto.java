package com.springBoot.ProjectTracker.dto.user_dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    @NotBlank(message = "first name can't left blank")
    @Size(min = 2, message = "first name must be 2 character or long")
    private String userFirstName;

    @NotBlank(message = "last name can't left blank")
    @Size(min = 2, message = "last name must be 2 character or long")
    private String userLastName;

    @NotBlank(message = "department code is mandatory")
    private String userDeptCode;

    @NotBlank(message = "Role is mandatory")
    private String userRole;

    @Email
    @NotBlank(message = "mention email")
    private String userEmail;

}

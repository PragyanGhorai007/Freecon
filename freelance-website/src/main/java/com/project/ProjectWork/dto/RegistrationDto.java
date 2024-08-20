package com.project.ProjectWork.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Component
@Getter
@Setter
@ToString
public class RegistrationDto {
    @NotBlank(message = "First Name can not be empty!!!")
    private String firstName;
    @NotBlank(message = "Last Name can not be empty!!!")
    private String lastName;
    @NotBlank(message = "Email can not be empty!!!")
    @Email(message = "Please provide a valid email address!!!")
    private String email;
    @NotBlank(message = "Password can not be empty!!!")
    private String password;
    private String repassword;
}

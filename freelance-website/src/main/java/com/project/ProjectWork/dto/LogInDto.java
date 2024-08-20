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
public class LogInDto {
    @Email(message = "Please provide a valid email address!!!")
    @NotBlank(message = "Email can not be empty!!!")
    private String email;
    @NotBlank(message = "Password can not be empty!!!")
    private String password;
}

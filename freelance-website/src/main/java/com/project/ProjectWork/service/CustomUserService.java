package com.project.ProjectWork.service;

import com.project.ProjectWork.dto.LogInDto;
import com.project.ProjectWork.entity.CustomUser;

import java.util.List;

public interface CustomUserService {
    List<CustomUser> getAllUser();

    CustomUser save(CustomUser customUser);
    CustomUser findUserByEmail(LogInDto logInDto);
    boolean existsUserByEmail(String email);
}

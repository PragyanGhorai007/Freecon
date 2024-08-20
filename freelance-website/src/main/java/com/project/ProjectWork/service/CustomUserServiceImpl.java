package com.project.ProjectWork.service;

import com.project.ProjectWork.dto.LogInDto;
import com.project.ProjectWork.dto.RegistrationDto;
import com.project.ProjectWork.entity.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.ProjectWork.repository.CustomUserRepository;

import java.util.List;
import java.util.Objects;

@Service
public class CustomUserServiceImpl implements CustomUserService {

    @Autowired
    private CustomUserRepository customUserRepository;

    public CustomUserServiceImpl(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }


    @Override
    public List<CustomUser> getAllUser() {
        return customUserRepository.findAll();
    }

    @Override
    public CustomUser save(CustomUser customUser) {
        System.out.println(customUser);
        return customUserRepository.save(customUser);
    }

    @Override
    public CustomUser findUserByEmail(LogInDto logInDto) {
        CustomUser customUser;
        customUser = customUserRepository.findByEmail(logInDto.getEmail());
        if (customUser != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            if (passwordEncoder.matches(logInDto.getPassword(), customUser.getPassword())) {
                customUser.setId(0);
                customUser.setPassword("");
                return customUser;
            }
        }
        return null;
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return customUserRepository.existsByEmail(email);
    }

}

package com.project.ProjectWork.controller;

import com.project.ProjectWork.dto.JobDto;
import com.project.ProjectWork.dto.LogInDto;
import com.project.ProjectWork.dto.RegistrationDto;
import com.project.ProjectWork.entity.CustomUser;
import com.project.ProjectWork.entity.Job;
import com.project.ProjectWork.repository.CustomUserRepository;
import com.project.ProjectWork.service.CustomUserService;
import com.project.ProjectWork.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ApiController {
    @Autowired
    private CustomUserService userService;
    @Autowired
    private JobService jobService;

    @PostMapping("/reg_process")
    public String registrationProcess(@Valid @ModelAttribute("RegistrationDto") RegistrationDto registration, BindingResult result,HttpSession session) {
        if (!registration.getPassword().equals(registration.getRepassword())) {
            FieldError retypePassError = new FieldError("RegistrationDto", "repassword", "Password did not match!!!");
            result.addError(retypePassError);
        }
        if (result.hasErrors()) {
            return "registration";
        } else {
            CustomUser customUser = new CustomUser();
            customUser.setEmail(registration.getEmail());
            if (userService.existsUserByEmail(registration.getEmail()))
            {
                session.setAttribute("message","This User have already exist!!!");
                return "registration";

            }
            customUser.setFirstName(registration.getFirstName());
            customUser.setLastName(registration.getLastName());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            String encodedPassword = passwordEncoder.encode(registration.getPassword());
            customUser.setPassword(encodedPassword);
            userService.save(customUser);
            return "register_success";
        }

    }

    @PostMapping("/processLogin")
    public String processLogin(@Valid @ModelAttribute("LogInDto") LogInDto logInDto, BindingResult result,HttpSession session) {
        if(result.hasErrors()) {
            return "login";
        } else {
            CustomUser userDetails = userService.findUserByEmail(logInDto);
            System.out.println(userDetails.getFirstName());
            if (null != userDetails) {
                return "user";
            }
            session.setAttribute("message","Bad Credential!!!");
            return "login";
        }
    }
    @PostMapping("/postProcess")
    public String postProcessing(@Valid @ModelAttribute("JobData") Job job, BindingResult r){
        System.out.println(job);
        if(job.getMin()>=job.getMax())
        {
            FieldError retypePassError = new FieldError("JobData", "min", "Min price>=Max price!!!!");
            r.addError(retypePassError);
            System.out.println(r);
            return "postJob";
        }
        jobService.save(job);
            return "home";
    }
}

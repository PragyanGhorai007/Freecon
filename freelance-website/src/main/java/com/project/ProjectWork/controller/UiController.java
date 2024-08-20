package com.project.ProjectWork.controller;

import com.project.ProjectWork.dto.JobDto;
import com.project.ProjectWork.dto.LogInDto;
import com.project.ProjectWork.dto.RegistrationDto;
import com.project.ProjectWork.service.JobService;
import com.project.ProjectWork.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UiController {
    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {

//        return "user_view";
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("LogInDto", new LogInDto());
        return "login";
    }

    @GetMapping("/registration")
    public String openRegistration(Model model) {
        model.addAttribute("RegistrationDto", new RegistrationDto());
        return "registration";

    }

    @RequestMapping(value = "/pragyan",method = RequestMethod.GET)
    public String users() {
        return "user";
    }

    @GetMapping("/postJob")
    public String jobPost(Model model) {
        model.addAttribute("JobData", new JobDto());
        return "postJob";
    }

    @GetMapping("/listOfJob")
    public String jobList(Model model) {
        List<Job> jobs=jobService.findAllJob();
             model.addAttribute("jobs",jobs);
         return "job-list";
    }
}

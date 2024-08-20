package com.project.ProjectWork.service;

import com.project.ProjectWork.dto.JobDto;
import com.project.ProjectWork.entity.Job;

import java.util.List;


public interface JobService {
    void save(Job job);

     List<Job> findAllJob();

}

package com.project.ProjectWork.service;

import com.project.ProjectWork.dto.JobDto;
import com.project.ProjectWork.entity.Job;
import com.project.ProjectWork.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{
    @Autowired
    private JobRepository jobRepository;
    @Override
    public void save(Job job) {
//
        jobRepository.save(job);
    }

    @Override
    public List<Job> findAllJob() {
        return jobRepository.findAll();
    }
}

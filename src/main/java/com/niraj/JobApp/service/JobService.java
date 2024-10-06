package com.niraj.JobApp.service;
import com.niraj.JobApp.model.JobPost;
import com.niraj.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.addJobPost(jobPost);

    }

    public List<JobPost> getAllJobs(){
        return repo.returnAllJobPosts();
    }
}

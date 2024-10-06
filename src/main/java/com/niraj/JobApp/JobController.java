package com.niraj.JobApp;

import com.niraj.JobApp.model.JobPost;
import com.niraj.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobservice;

    @GetMapping({"/", "home"})
    public String home(){
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @GetMapping("viewalljobs")
    public String viewjobs(Model m){
        List<JobPost> post = jobservice.getAllJobs();
        m.addAttribute("jobPosts",post);
        return "viewalljobs";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        jobservice.addJob(jobPost);
        return "success";
    }



}

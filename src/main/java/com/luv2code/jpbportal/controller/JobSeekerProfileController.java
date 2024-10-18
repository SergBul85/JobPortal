package com.luv2code.jpbportal.controller;

import com.luv2code.jpbportal.entity.JobSeekerProfile;
import com.luv2code.jpbportal.entity.Skills;
import com.luv2code.jpbportal.repository.UsersRepository;
import com.luv2code.jpbportal.services.JobSeekerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/job-seeker-profile")
public class JobSeekerProfileController {
    private JobSeekerProfileService jobSeekerProfileService;
    private UsersRepository usersRepository;

    @Autowired
    public JobSeekerProfileController(JobSeekerProfileService jobSeekerProfileService, UsersRepository usersRepository) {
        this.jobSeekerProfileService = jobSeekerProfileService;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/")
    public String StringJobSeekerProfile(Model model) {
        JobSeekerProfile jobSeekerProfile = new JobSeekerProfile();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Skills> skills = new ArrayList<Skills>();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            usersRepository.findByEmail(authentication.getName()).
                    orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        }
        return "job-seeker-profile";
    }

}

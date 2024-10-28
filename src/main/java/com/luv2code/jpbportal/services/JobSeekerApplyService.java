package com.luv2code.jpbportal.services;

import com.luv2code.jpbportal.entity.JobPostActivity;
import com.luv2code.jpbportal.entity.JobSeekerApply;
import com.luv2code.jpbportal.entity.JobSeekerProfile;
import com.luv2code.jpbportal.repository.JobSeekerApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerApplyService {

    private final JobSeekerApplyRepository jobSeekerApplyRepository;

    @Autowired
    public JobSeekerApplyService(JobSeekerApplyRepository jobSeekerApplyRepository) {
        this.jobSeekerApplyRepository = jobSeekerApplyRepository;
    }

    public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId) {
        return jobSeekerApplyRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerApply> getJobsCandidates(JobPostActivity job) {
        return jobSeekerApplyRepository.findByJob(job);
    }

}

package com.luv2code.jpbportal.repository;

import com.luv2code.jpbportal.entity.JobPostActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {
    List<IRecruiterJobs> getRecruiterJObs(@Param("recruiter") int recruiter);
}

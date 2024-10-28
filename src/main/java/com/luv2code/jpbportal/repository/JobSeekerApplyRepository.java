package com.luv2code.jpbportal.repository;

import com.luv2code.jpbportal.entity.JobPostActivity;
import com.luv2code.jpbportal.entity.JobSeekerApply;
import com.luv2code.jpbportal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);


}

package com.luv2code.jpbportal.repository;


import com.luv2code.jpbportal.entity.JobPostActivity;
import com.luv2code.jpbportal.entity.JobSeekerProfile;
import com.luv2code.jpbportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);


}

package com.luv2code.jpbportal.entity;


public class RecruiterJobsDto {

    private Long totalCandidates;
    private Integer jobPostId;
    private String jobTitle;
    private JobLocation jobLocation;
    private JobCompany jobCompanIdy;

    public RecruiterJobsDto(JobCompany jobCompanIdy, JobLocation jobLocation, String jobTitle, Integer jobPostId, Long totalCandidates) {
        this.jobCompanIdy = jobCompanIdy;
        this.jobLocation = jobLocation;
        this.jobTitle = jobTitle;
        this.jobPostId = jobPostId;
        this.totalCandidates = totalCandidates;
    }

    public Long getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(Long totalCandidates) {
        this.totalCandidates = totalCandidates;
    }

    public Integer getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(Integer jobPostId) {
        this.jobPostId = jobPostId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JobLocation getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public JobCompany getJobCompanIdy() {
        return jobCompanIdy;
    }

    public void setJobCompanIdy(JobCompany jobCompanIdy) {
        this.jobCompanIdy = jobCompanIdy;
    }



}

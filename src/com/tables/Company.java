package com.tables;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Company {
	
	private int companyID;
    private String companyName;
    private String location;
	public Company(int companyID, String companyName, String location) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
		this.location = location;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companyName=" + companyName + ", location=" + location + "]";
	}
    
	List<JobListing> newJob=new ArrayList<>();
    public void postJob(String jobTitle, String jobDescription, String jobLocation, double salary, String jobType, Timestamp postedDate) {
        
        newJob.add( new JobListing(newJob.size() + 1, companyID, jobTitle, jobDescription, jobLocation, salary, jobType, postedDate));
        System.out.println("Job listing posted successfully.");
    }

    // Method to retrieve the list of job listings
    public List<JobListing> getJobListings() {
        return newJob;
    }

}
